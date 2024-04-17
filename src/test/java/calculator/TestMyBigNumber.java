package calculator;

import calculator.operand.MyBigNumber;
import calculator.operation.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
        assertEquals(value.toString(), myBigNumber.toString());
    }



}
