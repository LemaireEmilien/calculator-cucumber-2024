package calculator;

import calculator.operand.MyBigNumber;
import calculator.operand.MyNaN;
import calculator.operand.MyNumber;
import calculator.operation.*;
import calculator.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestParser {
    private Parser<Integer> parser;
    private Calculator<Integer> calculator;

    @BeforeEach
    void setUp() {
        parser = new Parser<>();
        calculator = new Calculator<>();
    }

    @Test
    void testNaN() {
        try {
            Expression<Integer> expression = parser.parse("5*4 + 3 * 3 - 458 * 740 /0 * 90 +4 -870 / 8", Parser::stringToInteger);
            assertEquals(new MyNaN<Integer>(), calculator.eval(expression));
        } catch (IllegalExpression e) {
            fail();
        }
    }

    @Test
    void testIllegalExpression() {
        assertThrows(IllegalExpression.class, () -> parser.parse("abrav12(85) + 78", Parser::stringToInteger));
        assertThrows(IllegalExpression.class, () -> parser.parse(" + ", Parser::stringToInteger));
        assertThrows(IllegalExpression.class, () -> parser.parse(" 50 -6 *540 + ", Parser::stringToInteger));
        assertThrows(IllegalExpression.class, () -> parser.parse("", Parser::stringToInteger));
    }

    @Test
    void testCorrectExpressions() {
        try {
            Expression<Integer> expression = parser.parse("5*4 + 3 * 3", Parser::stringToInteger);
            assertEquals(new MyNumber(29), calculator.eval(expression));
            expression = parser.parse("9856 + 6450 - 981 /89 +654", Parser::stringToInteger);
            assertEquals(new MyNumber(16949), calculator.eval(expression));
            expression = parser.parse("(3+3)*(((1)+3)*2)", Parser::stringToInteger);
            assertEquals(new MyNumber(48), calculator.eval(expression));
            expression = parser.parse("3 * 5 * 4 *6 /4 /6 *6 *8 /6", Parser::stringToInteger);
            assertEquals(new MyNumber(120), calculator.eval(expression));
            expression = parser.parse("-3", Parser::stringToInteger);
            assertEquals(new MyNumber(-3), calculator.eval(expression));
            expression = parser.parse("((4))(2+2)(8/2)(-1)", Parser::stringToInteger);
            assertEquals(new MyNumber(-64), calculator.eval(expression));
            expression = parser.parse("2**2", Parser::stringToInteger);
            assertEquals(new MyNumber(4), calculator.eval(expression));
        } catch (IllegalExpression e) {
            fail();
        }
    }

    @Test
    void testPostfix() {
        try {
            Expression<Integer> expression = parser.parse("((5 4)* , (3,3)*)+", Parser::stringToInteger);
            assertEquals(new MyNumber(29), calculator.eval(expression));
            expression = parser.parse("(((9856 6450)+ (981 89) / )- 654)+", Parser::stringToInteger);
            assertEquals(new MyNumber(16949), calculator.eval(expression));
            expression = parser.parse("((3 3)+ (((1),3)+2)*)*", Parser::stringToInteger);
            assertEquals(new MyNumber(48), calculator.eval(expression));
            expression = parser.parse("(3  5  4 6 )*", Parser::stringToInteger);
            assertEquals(new MyNumber(360), calculator.eval(expression));
        } catch (IllegalExpression e) {
            fail();
        }
    }


    @Test
    void testPrefix() {
        try {
            Expression<Integer> expression = parser.parse("+(*(5 4) , *(3,3))", Parser::stringToInteger);
            assertEquals(new MyNumber(29), calculator.eval(expression));
            expression = parser.parse("+(-(+(9856 6450) /(981 89)) 654)", Parser::stringToInteger);
            assertEquals(new MyNumber(16949), calculator.eval(expression));
            expression = parser.parse("*(+(3 3) *(+((1),3)2))", Parser::stringToInteger);
            assertEquals(new MyNumber(48), calculator.eval(expression));
            expression = parser.parse("*(3  5  4 6 )", Parser::stringToInteger);
            assertEquals(new MyNumber(360), calculator.eval(expression));
        } catch (IllegalExpression e) {
            fail();
        }
    }

    @Test
    void testBoolean() {
        Calculator<Integer> c = new Calculator<>();

        try {
            Expression<Integer> e = parser.parse("true & false & true", Parser::stringToInteger);
            assertEquals(new MyNumber(0), c.eval(e));

            e = parser.parse("true | false | true", Parser::stringToInteger);
            assertEquals(new MyNumber(1), c.eval(e));

            e = parser.parse("true & false | true", Parser::stringToInteger);
            assertEquals(new MyNumber(1), c.eval(e));

            e = parser.parse("true | false & true", Parser::stringToInteger);
            assertEquals(new MyNumber(1), c.eval(e));

            e = parser.parse("true | false => false", Parser::stringToInteger);
            assertEquals(new MyNumber(0), c.eval(e));

            e = parser.parse("true ^ true ^ true", Parser::stringToInteger);
            assertEquals(new MyNumber(1), c.eval(e));
        } catch (IllegalExpression e) {
            fail();
        }
    }

    @Test
    void testMoreArithmetic(){
        try {
            Parser<BigDecimal> parser = new Parser<>();
            Expression<BigDecimal> e = parser.parse("sin(1)", Parser::stringToBigDecimal);
            assertEquals(new Sin<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("cos(1)", Parser::stringToBigDecimal);
            assertEquals(new Cos<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("tan(1)", Parser::stringToBigDecimal);
            assertEquals(new Tan<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("acos(1)", Parser::stringToBigDecimal);
            assertEquals(new Acos<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("asin(1)", Parser::stringToBigDecimal);
            assertEquals(new Asin<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("atan(1)", Parser::stringToBigDecimal);
            assertEquals(new Atan<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("log(1)", Parser::stringToBigDecimal);
            assertEquals(new Logarithm<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("ln(1)", Parser::stringToBigDecimal);
            assertEquals(new NaturalLog<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("sqrt(1)", Parser::stringToBigDecimal);
            assertEquals(new SquareRoot<>(List.of(new MyBigNumber(1))), e);
            e = parser.parse("mod(1,2)", Parser::stringToBigDecimal);
            assertEquals(new Modulo<>(List.of(new MyBigNumber(1),new MyBigNumber(2))), e);
            e = parser.parse("rand(1)", Parser::stringToBigDecimal);
            assertEquals(new Rand<>(List.of(new MyBigNumber(1))), e);
        } catch (IllegalConstruction | IllegalExpression e) {
            fail();
        }
    }


}
