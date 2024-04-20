package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Value;

import java.util.List;

public final class Modulo<T> extends Operation<T> {

    /**
     * Class constructor specifying a number of Expressions to do modulo.
     *
     * @param elist The list of Expressions to modulo
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     */
    public /*constructor*/ Modulo(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "mod";
    }

    /**
     * The modulo of two integers
     *
     * @param l The first integer
     * @param r The second integer that should be added to the first
     * @return The integer that is the result of the modulo
     */
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.modulo(r);
    }
}
