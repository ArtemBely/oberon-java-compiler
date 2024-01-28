package semanticanalysis;

import gen.OberonParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LLVMIRGenerator {

    private void visitModule(OberonParser.ModuleContext ctx, StringBuilder llvmIr) {
        for (OberonParser.DeclarationContext decl : ctx.declaration()) {
            if (decl.varDeclaration() != null) {
                visitVarDeclaration(decl.varDeclaration(), llvmIr);
            } else if (decl.arrayDeclaration() != null) {
                visitArrayDeclaration(decl.arrayDeclaration(), llvmIr);
            }
        }

        for (OberonParser.StatementContext stmt : ctx.statement()) {
            visitStatement(stmt, llvmIr);
        }
    }

    private Map<String, String> variableTypes = new HashMap<>();

    private void visitVarDeclaration(OberonParser.VarDeclarationContext ctx, StringBuilder llvmIr) {
        OberonParser.TypeContext typeCtx = ctx.type();
        String varType = llvmType(typeCtx);

        for (OberonParser.IdentContext idCtx : ctx.identList().ident()) {
            llvmIr.append("%").append(idCtx.getText()).append(" = alloca ").append(varType).append("\n");
        }
    }

    private String llvmArrayType(OberonParser.ArrayTypeContext arrayTypeCtx) {
        int arraySize = Integer.parseInt(arrayTypeCtx.number().getText());
        String elementType = llvmType(arrayTypeCtx.type());

        return "[" + arraySize + " x " + elementType + "]";
    }


    private void visitStatement(OberonParser.StatementContext ctx, StringBuilder llvmIr) {
        if (ctx.assignment() != null) {
            visitAssignment(ctx.assignment(), llvmIr);
        } else if (ctx.conditional() != null) {
            visitConditional(ctx.conditional(), llvmIr);
        }
    }

    private void visitConditional(OberonParser.ConditionalContext ctx, StringBuilder llvmIr) {
        String condition = generateExpression(ctx.expression(), llvmIr);

        String labelThen = "if.then";
        String labelElse = "if.else";
        String labelEnd = "if.end";

        llvmIr.append("br i1 ").append(condition).append(", label %").append(labelThen)
                .append(", label %").append(labelElse).append("\n");

        llvmIr.append(labelThen).append(":\n");
        visitProcedureStatement(ctx.procedureStatement(0), llvmIr);
        llvmIr.append("br label %").append(labelEnd).append("\n");

        llvmIr.append(labelElse).append(":\n");
        if (ctx.procedureStatement().size() > 1) {
            visitProcedureStatement(ctx.procedureStatement(1), llvmIr);
        }
        llvmIr.append("br label %").append(labelEnd).append("\n");

        llvmIr.append(labelEnd).append(":\n");
    }

    private void visitArrayDeclaration(OberonParser.ArrayDeclarationContext ctx, StringBuilder llvmIr) {
        OberonParser.ArrayTypeContext outerArrayType = ctx.arrayType();
        int outerArraySize = Integer.parseInt(outerArrayType.number().getText());
        OberonParser.ArrayTypeContext innerArrayType = outerArrayType.type().arrayType();
        int innerArraySize = Integer.parseInt(innerArrayType.number().getText());

        String innerElementType = llvmType(innerArrayType.type());
        String elementType = "[" + innerArraySize + " x " + innerElementType + "]";

        for (OberonParser.IdentContext identContext : ctx.identList().ident()) {
            String arrayName = identContext.getText();
            llvmIr.append("%").append(arrayName).append(" = alloca [")
                    .append(outerArraySize).append(" x ").append(elementType).append("]\n");
        }
    }


    private String generateExpression(OberonParser.ExpressionContext ctx, StringBuilder llvmIr) {
        if (ctx.relation() != null) {

            String leftExpr = generateSimpleExpression(ctx.simpleExpression(0), llvmIr);
            String rightExpr = generateSimpleExpression(ctx.simpleExpression(1), llvmIr);
            return generateRelation(leftExpr, ctx.relation().getText(), rightExpr, llvmIr);
        } else {
            return generateSimpleExpression(ctx.simpleExpression(0), llvmIr);
        }
    }


    private String generateSimpleExpression(OberonParser.SimpleExpressionContext ctx, StringBuilder llvmIr) {
        String result = generateTerm(ctx.term(0), llvmIr);
        for (int i = 1; i < ctx.term().size(); i++) {
            String operator = ctx.getChild(i * 2 - 1).getText();
            String nextTerm = generateTerm(ctx.term(i), llvmIr);
            result = generateBinaryOperation(result, operator, nextTerm, llvmIr);
        }
        return result;
    }

    private void visitProcedureStatement(OberonParser.ProcedureStatementContext ctx, StringBuilder llvmIr) {
        if (ctx.assignment() != null) {
            visitAssignment(ctx.assignment(), llvmIr);
        }
    }

    private void visitProcedureStatements(List<OberonParser.ProcedureStatementContext> statements, StringBuilder llvmIr, String labelEnd) {
        for (OberonParser.ProcedureStatementContext stmt : statements) {
            visitProcedureStatement(stmt, llvmIr);
        }
        llvmIr.append("br label %").append(labelEnd).append("\n");
    }

    private void visitAssignment(OberonParser.AssignmentContext ctx, StringBuilder llvmIr) {
        String targetVar = ctx.ident().getText();
        String targetVarType = variableTypes.getOrDefault(targetVar, "i32");
        OberonParser.ExpressionContext expression = ctx.expression().size() > 0 ? ctx.expression().get(0) : null;

        if (expression != null) {
            String llvmValue = generateExpression(expression, llvmIr);

            if (targetVarType.equals("i1")) {
                String tempVar = "%temp" + tempVarCount++;
                llvmIr.append(tempVar).append(" = load i1, i1* %").append(targetVar).append("\n");
                llvmIr.append("br i1 ").append(tempVar).append(", label %if.then, label %if.else\n");
            }  else {
                if (ctx.multiDimensionalIndex() != null) {
                    String tempVarOuter = "%temp" + tempVarCount++;
                    llvmIr.append(tempVarOuter).append(" = getelementptr [2 x [3 x i32]], [2 x [3 x i32]]* %")
                            .append(targetVar).append(", i32 0, i32 ")
                            .append(generateExpression(ctx.multiDimensionalIndex().expression(0), llvmIr)).append("\n");

                    String tempVarInner = "%temp" + tempVarCount++;
                    llvmIr.append(tempVarInner).append(" = getelementptr [3 x i32], [3 x i32]* ")
                            .append(tempVarOuter).append(", i32 0, i32 ")
                            .append(generateExpression(ctx.multiDimensionalIndex().expression(1), llvmIr)).append("\n");

                    llvmIr.append("store i32 ").append(llvmValue).append(", i32* ").append(tempVarInner).append("\n");
                } else {
                    llvmIr.append("store ").append(targetVarType).append(" ").append(llvmValue)
                            .append(", ").append(targetVarType).append("* %").append(targetVar).append("\n");
                }
            }
        }
    }

    private String generateIndexCode(OberonParser.MultiDimensionalIndexContext indexCtx, StringBuilder llvmIr, String targetVar, String expressionType) {
        String tempVar = "%temp" + tempVarCount++;
        llvmIr.append(tempVar).append(" = getelementptr ")
                .append(expressionType).append(", ")
                .append(expressionType).append("* %").append(targetVar).append(", ")
                .append("i32 ").append("idx").append("\n");
        return tempVar;
    }

    private String llvmType(OberonParser.TypeContext typeCtx) {
        String oberonType = typeCtx.getText();
        if (typeCtx.arrayType() != null) {
            return llvmArrayType(typeCtx.arrayType());
        } else {
            return switch (oberonType) {
                case "REAL" -> "double";
                case "BOOLEAN" -> "i1";
                case "STRING" -> "[N x i8]";
                default -> "i32";
            };
        }
    }

    public String generateLLVMIR(ParserRuleContext tree) {
        StringBuilder llvmIr = new StringBuilder();
        llvmIr.append("define i32 @main() {\n");
        visitModule((OberonParser.ModuleContext) tree, llvmIr);
        llvmIr.append("ret i32 0\n");
        llvmIr.append("}\n");
        return llvmIr.toString();
    }

    private int tempVarCount = 0;

    private String generateTerm(OberonParser.TermContext ctx, StringBuilder llvmIr) {
        String result = generateFactor(ctx.factor(0), llvmIr);
        for (int i = 1; i < ctx.factor().size(); i++) {
            String operator = ctx.getChild(i * 2 - 1).getText();
            String nextFactor = generateFactor(ctx.factor(i), llvmIr);
            result = generateBinaryOperation(result, operator, nextFactor, llvmIr);
        }
        return result;
    }

    private String generateFactor(OberonParser.FactorContext ctx, StringBuilder llvmIr) {
        if (ctx.number() != null) {
            return ctx.number().getText();
        } else if (ctx.qualifiedIdent() != null) {
            String varName = ctx.qualifiedIdent().getText();
            String tempVar = "%temp" + (tempVarCount++);
            llvmIr.append(tempVar).append(" = load i32, i32* %").append(varName).append("\n");
            return tempVar;
        } else if (ctx.expression() != null) {
            return generateExpression(ctx.expression(), llvmIr);
        }
        return "";
    }

    private String generateRelation(String leftExpr, String relationOp, String rightExpr, StringBuilder llvmIr) {
        String tempVar = "%temp" + (tempVarCount++);
        String llvmOp = switch (relationOp) {
            case "=" -> "eq";
            case "#" -> "ne";
            case "<" -> "slt";
            case "<=" -> "sle";
            case ">" -> "sgt";
            case ">=" -> "sge";
            default -> throw new IllegalArgumentException("Unknown relation operator");
        };
        llvmIr.append(tempVar).append(" = icmp ").append(llvmOp).append(" i32 ").append(leftExpr).append(", ").append(rightExpr).append("\n");
        return tempVar;
    }

    private String generateBinaryOperation(String leftOperand, String operator, String rightOperand, StringBuilder llvmIr) {
        String tempVar = "%temp" + (tempVarCount++);
        String llvmOp = switch (operator) {
            case "+" -> "add";
            case "-" -> "sub";
            case "*" -> "mul";
            case "/" -> "sdiv";
            default -> throw new IllegalArgumentException("Unknown binary operator");
        };
        llvmIr.append(tempVar).append(" = ").append(llvmOp).append(" i32 ").append(leftOperand).append(", ").append(rightOperand).append("\n");
        return tempVar;
    }

}
