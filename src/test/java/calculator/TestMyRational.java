package calculator;

import calculator.operand.MyRational;
import calculator.operation.Times;
import calculator.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestMyRational {
    private final Rational rational = new Rational(4, 8);
    private MyRational myRational;

    @BeforeEach
    void setUp() {
        myRational = new MyRational(rational);
    }

    @Test
    void testEquals() {
        // Two distinct MyMyRational, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyRational(rational), myRational);
        // Two MyMyRationals containing a distinct value should not be equal:
        int otherValue = 7;
        assertNotEquals(new MyRational(7, 5), myRational);
        assertEquals(myRational, myRational); // Identity check (for coverage, as this should always be true)
        assertNotEquals(rational, otherValue); // number is of type MyMyRational, while value is of type int, so not equal
        try {
            assertNotEquals(new Times<>(new ArrayList<>()), rational);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testToString() {
        assertEquals(rational.toString(), myRational.toString());
    }

    @Test
    void testParserEval() {
        try {
            Parser<Rational> parser = new Parser<>();
            Calculator<Rational> calculator = new Calculator<>();
            Expression<Rational> expression = parser.parse("5*4 + 3 * 3", Parser::stringToRational);
            assertEquals(new MyRational(29), calculator.eval(expression));
            expression = parser.parse("+(-(+(9856 6450) /(981 89)) 654)", Parser::stringToRational);
            assertEquals(new MyRational(1508459, 89), calculator.eval(expression));
            expression = parser.parse("((4))(2+2)(8/2)(-1)", Parser::stringToRational);
            assertEquals(new MyRational(-64), calculator.eval(expression));
            expression = parser.parse("(3  5  4 6 )*", Parser::stringToRational);
            assertEquals(new MyRational(360), calculator.eval(expression));

            expression = parser.parse("1+1⁄2", Parser::stringToRational);
            assertEquals(new MyRational(3, 2), calculator.eval(expression));
            expression = parser.parse("1-1⁄2", Parser::stringToRational);
            assertEquals(new MyRational(1, 2), calculator.eval(expression));
            expression = parser.parse("8⁄9+3⁄4", Parser::stringToRational);
            assertEquals(new MyRational(59, 36), calculator.eval(expression));
            expression = parser.parse("8⁄9-3⁄4", Parser::stringToRational);
            assertEquals(new MyRational(5, 36), calculator.eval(expression));
            expression = parser.parse("8⁄9*3⁄4", Parser::stringToRational);
            assertEquals(new MyRational(2, 3), calculator.eval(expression));
            expression = parser.parse("8⁄9/3⁄4", Parser::stringToRational);
            assertEquals(new MyRational(32, 27), calculator.eval(expression));
        } catch (IllegalExpression e) {
            fail();
        }
    }


}
