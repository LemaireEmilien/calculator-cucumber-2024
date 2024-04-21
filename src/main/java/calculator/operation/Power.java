package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Value;

import java.util.List;

/**
 * This class represents the arithmetic sum operation "+".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 *
 * @see Operation
 * @see Minus
 * @see Times
 * @see Divides
 */
public final class Power<T> extends Operation<T> {

    /**
     * Class constructor specifying a number of Expressions to add.
     *
     * @param elist The list of Expressions to add
     * @throws IllegalConstruction If an empty list of expressions if passed as parameter
     */
    public /*constructor*/ Power(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "**";
    }

    /**
     * The actual computation of the (binary) arithmetic addition of two integers
     *
     * @param l The first integer
     * @param r The second integer that should be added to the first
     * @return The integer that is the result of the addition
     */
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.power(r);
    }
}
