package calculator;

import calculator.operand.MyBigNumber;
import calculator.operand.MyNumber;
import calculator.operation.*;
import calculator.parser.Parser;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A very simple calculator in Java
 * University of Mons - UMONS
 * Software Engineering Lab
 * Faculty of Sciences
 *
 * @author tommens
 */
@Slf4j
@SuppressWarnings("all")
public class Main {

    /**
     * This is the main method of the application.
     * It provides examples of how to use it to construct and evaluate arithmetic expressions.
     *
     * @param args Command-line parameters are not used in this version
     */
    public static void main(String[] args) {
        try {
            Parser<Integer> a = new Parser<>();
            //Expression<Integer> b = a.parse("!true", Parser::stringToInteger);
            Expression<Integer> b = new Not<Integer>(List.of(new MyNumber(1)));
            System.out.println(b);

            Expression<Integer> e;
            Calculator<Integer> c = new Calculator<>();
            c.print(b);/*
            e = new MyNumber(8);
            c.print(e);

            List<Expression<Integer>> params = new ArrayList<>();
            Collections.addAll(params, new MyNumber(3), new MyNumber(4), new MyNumber(5));
            e = new Plus<>(params);
            c.printExpressionDetails(e);

            List<Expression<Integer>> params2 = new ArrayList<>();
            Collections.addAll(params2, new MyNumber(5), new MyNumber(3));
            e = new Minus<>(params2);
            c.print(e);

            List<Expression<Integer>> params3 = new ArrayList<>();
            Collections.addAll(params3, new Plus<>(params), new Minus<>(params2));
            e = new Times<>(params3);
            c.printExpressionDetails(e);

            List<Expression<Integer>> params4 = new ArrayList<>();
            Collections.addAll(params4, new Plus<>(params), new Minus<>(params2), new MyNumber(5));
            e = new Divides<>(params4);
            c.print(e, Notation.POSTFIX);

            BigDecimal value1 = new BigDecimal("3.556454");
            BigDecimal value2 = new BigDecimal("4.556454");
            BigDecimal value3 = new BigDecimal("10e10");
            Expression<BigDecimal> e2;
            List<Expression<BigDecimal>> params5 = new ArrayList<>();
            Collections.addAll(params5, new MyBigNumber(value1), new MyBigNumber(value3));
            e2 = new Plus<>(params5);
            Calculator<BigDecimal> c2 = new Calculator<>();
            c2.print(e2);

            List<Expression<BigDecimal>> params6 = new ArrayList<>();
            Collections.addAll(params6, new MyBigNumber(value1), new MyBigNumber(8));
            e2 = new Minus<>(params6);
            c2.print(e2);

            Expression<BigDecimal> e3;
            List<Expression<BigDecimal>> params7 = new ArrayList<>();
            Collections.addAll(params7, new MyBigNumber(100));
            e3 = new Logarithm<>(params7);
            c2.print(e3);

            MyBigNumber.setPrecision(3);
            MyBigNumber five = new MyBigNumber(5);
            MyBigNumber five2 = new MyBigNumber(5.00001);
            System.out.println(five.val);
            System.out.println(five2.val);
            System.out.println(five.equals(five2));*/

        } catch (IllegalConstruction exception) {
            log.error("cannot create operations without parameters {}", exception);
        }
    }

}
