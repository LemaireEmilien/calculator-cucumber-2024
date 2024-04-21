package calculator;

import calculator.operand.MyNumber;
import calculator.operation.And;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestAnd {

    private final MyNumber True = new MyNumber(1);
    private final MyNumber False = new MyNumber(0);
    private final Calculator<Integer> calc = new Calculator<>();

    @Test
    void testAnd() {
        try {
            List<Expression<Integer>> params = Arrays.asList(True, True);
            And<Integer> and = new And<>(params);
            assertEquals(new MyNumber(1), calc.eval(and)); // 1 & 1 = 1

            params = Arrays.asList(True, False);
            and = new And<>(params);
            assertEquals(new MyNumber(0), calc.eval(and)); // 1 & 0 = 0

            params = Arrays.asList(False, True);
            and = new And<>(params);
            assertEquals(new MyNumber(0), calc.eval(and)); // 0 & 1 = 0

            params = Arrays.asList(False, False);
            and = new And<>(params);
            assertEquals(new MyNumber(0), calc.eval(and)); // 0 & 0 = 0

            params = Arrays.asList(True, True, True, False);
            and = new And<>(params);
            assertEquals(new MyNumber(0), calc.eval(and)); // 1 & 1 & 1 & 0 = 0
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
