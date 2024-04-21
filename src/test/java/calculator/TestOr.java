package calculator;

import calculator.operand.MyNumber;
import calculator.operation.Or;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestOr {

    private final MyNumber True = new MyNumber(1);
    private final MyNumber False = new MyNumber(0);
    private final Calculator<Integer> calc = new Calculator<>();

    @Test
    void testOr() {
        try {
            List<Expression<Integer>> params = Arrays.asList(True, True);
            Or<Integer> or = new Or<>(params);
            assertEquals(new MyNumber(1), calc.eval(or)); // 1 | 1 = 1

            params = Arrays.asList(True, False);
            or = new Or<>(params);
            assertEquals(new MyNumber(1), calc.eval(or)); // 1 | 0 = 1

            params = Arrays.asList(False, True);
            or = new Or<>(params);
            assertEquals(new MyNumber(1), calc.eval(or)); // 0 | 1 = 1

            params = Arrays.asList(False, False);
            or = new Or<>(params);
            assertEquals(new MyNumber(0), calc.eval(or)); // 0 | 0 = 0

            params = Arrays.asList(False, False, False, True);
            or = new Or<>(params);
            assertEquals(new MyNumber(1), calc.eval(or)); // 0 | 0 | 0 | 1 = 1
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
