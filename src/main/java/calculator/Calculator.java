package calculator;

import calculator.parser.CalculatorLexer;
import calculator.parser.CalculatorParser;
import calculator.parser.Parser;
import calculator.parser.VisitorParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import visitor.*;

/**
 * This class represents the core logic of a Calculator.
 * It can be used to print and evaluate artihmetic expressions.
 *
 * @author tommens
 */
@Slf4j
@NoArgsConstructor
public class Calculator<T> {

    /**
     * The read method is implemented with ANTLR4 parser.
     * We construct the AST with ANTLR4 and convert it into a valid expression
     * that the calculator can use.
     * @param s the string to parse
     * @return a new Expression
     */
    public Expression<Integer> read(String s) throws IllegalExpression {
        Parser<Integer> p = new Parser<>();
        return p.parse(s, Parser::stringToInteger);
    }

    /**
     * Prints an arithmetic expression provided as input parameter.
     *
     * @param e the arithmetic Expression to be printed
     * @see #printExpressionDetails(Expression)
     */
    public void print(Expression<T> e, Notation n) {
        Printer<T> v = new Printer<>(n);
        e.accept(v);

        log.info("The result of evaluating expression {} is {}.", v.getResult(), eval(e));
    }

    public void print(Expression<T> e) {
        Notation n = Notation.INFIX;
        print(e, n);
    }


    /**
     * Prints verbose details of an arithmetic expression provided as input parameter.
     *
     * @param e the arithmetic Expression to be printed
     * @see #print(Expression)
     */
    public void printExpressionDetails(Expression<T> e) {
        print(e);
        CountDepth<T> cd = new CountDepth<>();
        e.accept(cd);
        CountOps<T> co = new CountOps<>();
        e.accept(co);
        CountNbs<T> cn = new CountNbs<>();
        e.accept(cn);
        log.info("It contains {} levels of nested expressions, {} operations and {} numbers.", cd.getDepth(), co.getOps(), cn.getNbs());
    }

    /**
     * Evaluates an arithmetic expression and returns its result
     *
     * @param expr the arithmetic Expression to be evaluated
     * @return The result of the evaluation
     */
    public Value<T> eval(Expression<T> expr) {
        try {
            // create a new visitor to evaluate expressions
            Evaluator<T> v = new Evaluator<>();
            // and ask the expression to accept this visitor to start the evaluation process
            expr.accept(v);
            // and return the result of the evaluation at the end of the process
            return v.getResult();
        } catch (ArithmeticException e) {
            return new MyNaN<>();
        }

    }

    /*
     We could also have other methods, e.g. to verify whether an expression is syntactically correct
     public Boolean validate(Expression e)
     or to simplify some expression
     public Expression simplify(Expression e)
    */
}
