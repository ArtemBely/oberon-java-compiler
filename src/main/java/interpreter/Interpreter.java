package interpreter;

import exception.SemanticException;
import gen.OberonParser;
import gen.OberonBaseVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import semanticanalysis.SymbolTable;

import java.util.List;

public class Interpreter extends OberonBaseVisitor<Object> {

    private SymbolTable symbolTable;

    public Interpreter(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }
    public void interpret(ParserRuleContext tree) {
        try {
            visit(tree);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object visitAssignment(OberonParser.AssignmentContext ctx) {
        try {
            String varName = ctx.ident().getText();
            List<OberonParser.ExpressionContext> expressions = ctx.expression();
            Object value = null;
            if (!expressions.isEmpty()) {
                value = visit(expressions.get(0));
            }
            symbolTable.assign(varName, value);
        } catch (SemanticException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Object visitExpression(OberonParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        } else if (ctx.getChildCount() == 3) {
            Object left = visit(ctx.getChild(0));
            Object right = visit(ctx.getChild(2));
            String operator = ctx.getChild(1).getText();

            switch (operator) {
                case "+":
                    return (Integer) left + (Integer) right;
                case "-":
                    return (Integer) left - (Integer) right;
            }
        }
        return null;
    }
}

