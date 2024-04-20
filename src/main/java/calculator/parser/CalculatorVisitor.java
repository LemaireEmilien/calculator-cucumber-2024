package calculator.parser;// Generated from C:/Users/sacry_000/Documents/Git/calculator-cucumber-2024/src/main/antlr4/Calculator.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(CalculatorParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#multiplyingExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#powExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpression(CalculatorParser.PowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(CalculatorParser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#prefix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_expression(CalculatorParser.Prefix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(CalculatorParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#implication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(CalculatorParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(CalculatorParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#xorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXorExpression(CalculatorParser.XorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CalculatorParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(CalculatorParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#batom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBatom(CalculatorParser.BatomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#signedAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedAtom(CalculatorParser.SignedAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(CalculatorParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#scientific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScientific(CalculatorParser.ScientificContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CalculatorParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CalculatorParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#func_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_(CalculatorParser.Func_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(CalculatorParser.FuncnameContext ctx);
}