package calculator;

import calculator.operation.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestRational {

    private final int numerator = 4;
    private final int denominator = 8;
    private Rational rational;

    @BeforeEach
    void setUp() {
        rational = new Rational(numerator, denominator);
    }

    @Test
    void testEquals() {
        // Two distinct MyRational, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new Rational(numerator, denominator), rational);
        // Two MyRationals containing a distinct value should not be equal:
        int otherValue = 7;
        assertNotEquals(new Rational(otherValue, denominator), rational);
        assertEquals(rational, rational); // Identity check (for coverage, as this should always be true)
        assertNotEquals(rational, numerator); // number is of type MyRational, while value is of type int, so not equal
        try {
            assertNotEquals(new Times<>(new ArrayList<>()), rational);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testToString() {
        assertEquals(numerator + "⁄" + denominator, rational.toString());
        Rational r = new Rational(4, 1);
        assertEquals(4 + "", r.toString());
    }

    @Test
    void testSimplify() {
        assertEquals(new Rational(1, 2), rational.simplify());
    }

}
