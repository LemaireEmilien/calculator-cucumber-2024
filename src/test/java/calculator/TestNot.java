package calculator;

import calculator.operand.MyNumber;
import calculator.operation.And;
import calculator.operation.Not;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestNot {

    private final MyNumber True = new MyNumber(1);
    private final MyNumber False = new MyNumber(0);
    private final Calculator<Integer> calc = new Calculator<>();

    @Test
    void testNot() throws IllegalConstruction {
        Not<Integer> not = new Not<>(List.of(True));
        assertEquals(new MyNumber(0), calc.eval(not)); // !1 = 0

        not = new Not<>(List.of(False));
        assertEquals(new MyNumber(1), calc.eval(not)); // !0 = 1
    }

    @Test
    void testNot2() throws IllegalConstruction {
        And<Integer> and = new And<>(List.of(True, False));
        assertEquals(new MyNumber(0), calc.eval(and)); // 1 & 0 = 0
    }
}
