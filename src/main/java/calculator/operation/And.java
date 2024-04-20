package calculator.operation;

import calculator.*;

import java.util.List;

/** This class represents the boolean operation "AND".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Or
 * @see Not
 * @see Xor
 */
public final class And<T> extends Operation<T> {

    /**
     * Class constructor specifying a number of Expressions to AND.
     *
     * @param elist The list of Expressions to AND
     * @throws IllegalConstruction    If an empty list of expressions is passed as parameter
     */
    public And(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "&";
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.and(r);
    }
}
