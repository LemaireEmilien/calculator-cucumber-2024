package calculator;

//Import Junit5 libraries for unit testing:

import calculator.operand.MyNaN;
import calculator.operation.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestMyNaN {

    private MyNaN<Integer> nan;

    @BeforeEach
    void setUp() {
        nan = new MyNaN<>();
    }

    @Test
    void testEquals() {
        // Two distinct MyNaN, constructed separately (using a different constructor) but containing the same value should be equal
        assertEquals(new MyNaN<>(), nan);
        assertEquals(nan, nan); // Identity check (for coverage, as this should always be true)
        assertNotEquals(8, nan); // number is of type MyNaN, while value is of type int, so not equal
        try {
            assertNotEquals(new Times<>(new ArrayList<>()), nan);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testToString() {
        assertEquals("NaN", nan.toString());
    }

}
