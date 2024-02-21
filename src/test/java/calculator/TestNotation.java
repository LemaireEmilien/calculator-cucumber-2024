package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class TestNotation {

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotation(String s, Operation o, Notation n) {
        assertEquals(s, o.toString(n));
        o.notation = n;
        assertEquals(s, o.toString());
    }

    /* This is an auxilary method to avoid code duplication.
     */
    void testNotations(String symbol, int value1, int value2, Operation op) {
        //prefix notation:
        testNotation(symbol + "(" + value1 + ", " + value2 + ")", op, Notation.PREFIX);
        //infix notation:
        testNotation("(" + value1 + " " + symbol + " " + value2 + ")", op, Notation.INFIX);
        //postfix notation:
        testNotation("(" + value1 + ", " + value2 + ")" + symbol, op, Notation.POSTFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"*", "+", "/", "-"})
    void testOutput(String symbol) {
        int value1 = 8;
        int value2 = 6;
        Operation op = null;
        //List<Expression> params = new ArrayList<>(Arrays.asList(new MyNumber(value1),new MyNumber(value2)));
        List<Expression> params = Arrays.asList(new MyNumber(value1), new MyNumber(value2));
        try {
            //construct another type of operation depending on the input value
            //of the parameterised test
            switch (symbol) {
                case "+" -> op = new Plus(params);
                case "-" -> op = new Minus(params);
                case "*" -> op = new Times(params);
                case "/" -> op = new Divides(params);
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
        testNotations(symbol, value1, value2, op);
    }

    /*
    Test the mixing of notation in operator does not affect output
     */
    @Test
    void testMixedNotation() {
        List<Expression> params = new ArrayList<>();
        Collections.addAll(params, new MyNumber(3), new MyNumber(4), new MyNumber(5));
        List<Expression> params2 = new ArrayList<>();
        Collections.addAll(params2, new MyNumber(5), new MyNumber(3));

        List<Expression> params4 = new ArrayList<>();
        try {
            Collections.addAll(params4, new Plus(params,Notation.PREFIX), new Minus(params2,Notation.INFIX), new MyNumber(5));
            Operation o = new Divides(params4, Notation.POSTFIX);

            assertEquals("((3, 4, 5)+, (5, 3)-, 5)/",o.toString());
            assertEquals("/(+(3, 4, 5), -(5, 3), 5)",o.toString(Notation.PREFIX));
            assertEquals("((3 + 4 + 5) / (5 - 3) / 5)",o.toString(Notation.INFIX));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

}
