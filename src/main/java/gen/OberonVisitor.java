package gen;// Generated from C:/Users/belysheva/Desktop/OberonCompiler/src/main/resources/Oberon.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OberonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OberonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(OberonParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#importSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSection(OberonParser.ImportSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(OberonParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(OberonParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(OberonParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(OberonParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(OberonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#functionOrProcedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionOrProcedure(OberonParser.FunctionOrProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(OberonParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(OberonParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#parameterDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDecl(OberonParser.ParameterDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OberonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureStatement(OberonParser.ProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#multiDimensionalIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiDimensionalIndex(OberonParser.MultiDimensionalIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedIdent(OberonParser.QualifiedIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(OberonParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(OberonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(OberonParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(OberonParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(OberonParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(OberonParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(OberonParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#repeatLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatLoop(OberonParser.RepeatLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(OberonParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(OberonParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OberonParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(OberonParser.NumberContext ctx);
}