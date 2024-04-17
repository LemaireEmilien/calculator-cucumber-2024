package calculator.parser;// Generated from Calculator.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("all")
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
	 * Visit a parse tree produced by {@link CalculatorParser#rational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRational(CalculatorParser.RationalContext ctx);
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