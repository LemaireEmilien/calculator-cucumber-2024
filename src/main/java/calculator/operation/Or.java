package calculator.operation;

import calculator.*;

import java.util.List;

/** This class represents the boolean operation "OR".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see And
 * @see Not
 * @see Xor
 */
public class Or<T> extends Operation<T> {

    /**
     * Class constructor specifying a number of Expressions to OR.
     *
     * @param elist The list of Expressions to OR
     * @throws IllegalConstruction    If an empty list of expressions is passed as parameter
     */
    public Or(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "|";
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.or(r);
    }
}
