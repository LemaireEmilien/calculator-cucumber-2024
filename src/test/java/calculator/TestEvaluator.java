package calculator;

//Import Junit5 libraries for unit testing:

import calculator.operand.MyNaN;
import calculator.operand.MyNumber;
import calculator.operation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestEvaluator {

    private Calculator<Integer> calc;
    private int value1, value2;

    @BeforeEach
    void setUp() {
        calc = new Calculator<>();
        value1 = 8;
        value2 = 6;
    }

    @Test
    void testEvaluatorMyNumber() {
        assertEquals(new MyNumber(value1), calc.eval(new MyNumber(value1)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testEvaluateOperations(String symbol) {
        List<Expression<Integer>> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+" -> assertEquals(new MyNumber(value1 + value2), calc.eval(new Plus<>(params)));
                case "-" -> assertEquals(new MyNumber(value1 - value2), calc.eval(new Minus<>(params)));
                case "*" -> assertEquals(new MyNumber(value1 * value2), calc.eval(new Times<>(params)));
                case "/" -> assertEquals(new MyNumber(value1 / value2), calc.eval(new Divides<>(params)));
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Test
    void testDivisionByZero() {
        List<Expression<Integer>> params = Arrays.asList(new MyNumber(value1), new MyNumber(0));
        try {
            Plus<Integer> plus = new Plus<>(Arrays.asList(new Divides<>(params), new MyNumber(4)));
            assertEquals(new MyNaN<>(), calc.eval(plus));
        } catch (IllegalConstruction | ArithmeticException e) {
            fail();
        }
    }

    @Test
    void testOpposite() {
        try {
            assertEquals(new MyNumber(-value1), calc.eval(new Opposite<>(List.of(new MyNumber(value1)))));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

}
