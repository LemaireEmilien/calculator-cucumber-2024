package calculator;

import calculator.operand.MyBigNumber;
import calculator.operation.Sin;
import calculator.operation.Times;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestSin {
    private final double value1 = 8;
    private Sin<BigDecimal> op;
    private List<Expression<BigDecimal>> params;

    @BeforeEach
    void setUp() {
        params = List.of(new MyBigNumber(BigDecimal.valueOf(value1)));
        try {
            op = new Sin<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testConstructor1() {
        // It should not be possible to create an expression without null parameter list
        assertThrows(IllegalConstruction.class, () -> op = new Sin<>(null));
    }

    @SuppressWarnings("AssertBetweenInconvertibleTypes")
    @Test
    void testConstructor2() {
        // A Times expression should not be the same as a Sin expression
        try {
            assertNotSame(op, new Times<>(new ArrayList<>()));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testEquals() {
        // Two similar expressions, constructed separately (and using different constructors) should be equal
        List<Expression<BigDecimal>> p = List.of(new MyBigNumber(BigDecimal.valueOf(value1)));
        try {
            Sin<BigDecimal> d = new Sin<>(p);
            assertEquals(op, d);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void testNull() {
        assertDoesNotThrow(() -> op == null); // Direct way to to test if the null case is handled.
    }

    @Test
    void testHashCode() {
        // Two similar expressions, constructed separately (and using different constructors) should have the same hashcode
        List<Expression<BigDecimal>> p = List.of(new MyBigNumber(BigDecimal.valueOf(value1)));
        try {
            Sin<BigDecimal> e = new Sin<>(p);
            assertEquals(e.hashCode(), op.hashCode());
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testNullParamList() {
        params = null;
        assertThrows(IllegalConstruction.class, () -> op = new Sin<>(params));
    }

    @Test
    void testMoreOneParam() {
        assertThrows(IllegalConstruction.class, () -> new Sin<>(List.of(new MyBigNumber(4), new MyBigNumber(5))));
    }

}
