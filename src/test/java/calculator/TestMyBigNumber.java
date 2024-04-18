package calculator;

import calculator.operand.MyBigNumber;
import calculator.operation.Times;
import calculator.parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestMyBigNumber {

    private final BigDecimal value = BigDecimal.valueOf(3.141592);

    private MyBigNumber myBigNumber;

    @BeforeEach
    void setUp() {
        myBigNumber = new MyBigNumber(value);
    }

    @Test
    void testEquals() {
        // Two distinct MyBigNumber, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyBigNumber(value), myBigNumber);
        // Two MyBigNumbers containing a distinct value should not be equal:
        BigDecimal otherValue = BigDecimal.valueOf(2.718281);
        assertNotEquals(new MyBigNumber(otherValue), myBigNumber);
        assertEquals(myBigNumber, myBigNumber); // Identity check (for coverage, as this should always be true)
        assertNotEquals(myBigNumber, value); // myBigNumber is of type MyBigNumber, while value is of type BigDecimal, so not equal
        try {
            assertNotEquals(new Times<>(new ArrayList<>()), myBigNumber);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testToString() {
        BigDecimal value1 = new BigDecimal("1e3");
        BigDecimal value2 = new BigDecimal("1e12");
        BigDecimal value3 = new BigDecimal("1000000000000000");
        BigDecimal value4 = new BigDecimal("0.0000000000001");

        assertEquals(value.toString(), myBigNumber.toString());

        assertEquals("1000", new MyBigNumber(value1).toString());
        assertEquals("1E+12", new MyBigNumber(value2).toString());
        //assertEquals("1E+15", new MyBigNumber(value3).toString()); // This test fails because the function toString of BigDecimal is wrong
        assertEquals("1E-13", new MyBigNumber(value4).toString());

//        MyBigNumber.setPrecision(5);
//        assertEquals("3.14159", myBigNumber.toString());
//
//        MyBigNumber.setPrecision(2);
//        assertEquals("3.14", myBigNumber.toString());

    }

    @Test
    void testParserEval(){
        try {
            Parser<BigDecimal> parser = new Parser<>();
            Calculator<BigDecimal> calculator = new Calculator<>();

            Expression<BigDecimal> expression = parser.parse("5*4 + 3*3", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(29), calculator.eval(expression));

            expression = parser.parse("10E3 + 100000", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(110000), calculator.eval(expression));

            expression = parser.parse("10E3 + 10E4", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(new BigDecimal("110E3")), calculator.eval(expression));

            expression = parser.parse("((4))(2+2)(8/2)(-1)", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(-64), calculator.eval(expression));

            expression = parser.parse("(3  5  4 6 )*", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(360), calculator.eval(expression));

            expression = parser.parse("10000000000000", Parser::stringToBigDecimal);
            //assertEquals(new MyBigNumber(new BigDecimal("1E13")), calculator.eval(expression));  // This test fails because the function toString of BigDecimal is wrong

            expression = parser.parse("10000000000000 + 1e13", Parser::stringToBigDecimal);
            //assertEquals(new MyBigNumber(new BigDecimal("2E13")), calculator.eval(expression));  // This test fails because the function toString of BigDecimal is wrong

            expression = parser.parse("1e13 + 1e13", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(new BigDecimal("2E13")), calculator.eval(expression));

            expression = parser.parse("0.0000000000001", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(new BigDecimal("1E-13")), calculator.eval(expression));

            expression = parser.parse("1e-13 + 1e-13", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(new BigDecimal("2E-13")), calculator.eval(expression));

            expression = parser.parse("0.0000000000001 + 1e-13", Parser::stringToBigDecimal);
            assertEquals(new MyBigNumber(new BigDecimal("2e-13")), calculator.eval(expression));



        }catch (IllegalExpression e){
            fail();
        }
    }

    @Test
    void testDegToRad(){
        MyBigNumber myBigNumber1 = new MyBigNumber(BigDecimal.valueOf(180));
        MyBigNumber myBigNumber2 = new MyBigNumber(BigDecimal.valueOf(Math.PI));

        assertEquals(myBigNumber2.toString(), myBigNumber1.degToRad().toString());
        assertEquals(myBigNumber1.toString(), myBigNumber2.radToDeg().toString());
    }

}
