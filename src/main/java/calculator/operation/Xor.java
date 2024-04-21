package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Value;

import java.util.List;

/**
 * This class represents the boolean operation "XOR".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 *
 * @see Operation
 * @see And
 * @see Not
 * @see Or
 */
public class Xor<T> extends Operation<T> {

    /**
     * Class constructor specifying a number of Expressions to XOR.
     *
     * @param elist The list of Expressions to XOR
     * @throws IllegalConstruction If an empty list of expressions is passed as parameter
     */
    public Xor(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "^";
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.xor(r);
    }
}
