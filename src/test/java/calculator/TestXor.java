package calculator;

import calculator.operand.MyNumber;
import calculator.operation.Xor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestXor {

    private final MyNumber True = new MyNumber(1);
    private final MyNumber False = new MyNumber(0);
    private final Calculator<Integer> calc = new Calculator<>();

    @Test
    void testXor() {
        try {
            List<Expression<Integer>> params = List.of(True, True);
            Xor<Integer> xor = new Xor<>(params);
            assertEquals(new MyNumber(0), calc.eval(xor)); // 1 ^ 1 = 0

            params = List.of(True, False);
            xor = new Xor<>(params);
            assertEquals(new MyNumber(1), calc.eval(xor)); // 1 ^ 0 = 1

            params = List.of(False, True);
            xor = new Xor<>(params);
            assertEquals(new MyNumber(1), calc.eval(xor)); // 0 ^ 1 = 1

            params = List.of(False, False);
            xor = new Xor<>(params);
            assertEquals(new MyNumber(0), calc.eval(xor)); // 0 ^ 0 = 0

            params = List.of(False, False, False, True);
            xor = new Xor<>(params);
            assertEquals(new MyNumber(1), calc.eval(xor)); // 0 ^ 0 ^ 0 ^ 1 = 1
        } catch (IllegalConstruction e) {
            fail();
        }
    }
}
