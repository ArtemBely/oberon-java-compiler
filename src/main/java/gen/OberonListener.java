package gen;// Generated from C:/Users/belysheva/Desktop/OberonCompiler/src/main/resources/Oberon.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OberonParser}.
 */
public interface OberonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(OberonParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(OberonParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#importSection}.
	 * @param ctx the parse tree
	 */
	void enterImportSection(OberonParser.ImportSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#importSection}.
	 * @param ctx the parse tree
	 */
	void exitImportSection(OberonParser.ImportSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(OberonParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(OberonParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(OberonParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(OberonParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(OberonParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(OberonParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(OberonParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#arrayDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(OberonParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(OberonParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(OberonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(OberonParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 */
	void enterIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#identList}.
	 * @param ctx the parse tree
	 */
	void exitIdentList(OberonParser.IdentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#functionOrProcedure}.
	 * @param ctx the parse tree
	 */
	void enterFunctionOrProcedure(OberonParser.FunctionOrProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#functionOrProcedure}.
	 * @param ctx the parse tree
	 */
	void exitFunctionOrProcedure(OberonParser.FunctionOrProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(OberonParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(OberonParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(OberonParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(OberonParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(OberonParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#parameterDecl}.
	 * @param ctx the parse tree
	 */
	void enterParameterDecl(OberonParser.ParameterDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#parameterDecl}.
	 * @param ctx the parse tree
	 */
	void exitParameterDecl(OberonParser.ParameterDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(OberonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(OberonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcedureStatement(OberonParser.ProcedureStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcedureStatement(OberonParser.ProcedureStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(OberonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#multiDimensionalIndex}.
	 * @param ctx the parse tree
	 */
	void enterMultiDimensionalIndex(OberonParser.MultiDimensionalIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#multiDimensionalIndex}.
	 * @param ctx the parse tree
	 */
	void exitMultiDimensionalIndex(OberonParser.MultiDimensionalIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(OberonParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdent(OberonParser.QualifiedIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdent(OberonParser.QualifiedIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(OberonParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(OberonParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(OberonParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(OberonParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(OberonParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(OberonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(OberonParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(OberonParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(OberonParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(OberonParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(OberonParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(OberonParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(OberonParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(OberonParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(OberonParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(OberonParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(OberonParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#repeatLoop}.
	 * @param ctx the parse tree
	 */
	void enterRepeatLoop(OberonParser.RepeatLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#repeatLoop}.
	 * @param ctx the parse tree
	 */
	void exitRepeatLoop(OberonParser.RepeatLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(OberonParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(OberonParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(OberonParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(OberonParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OberonParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(OberonParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link OberonParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(OberonParser.NumberContext ctx);
}