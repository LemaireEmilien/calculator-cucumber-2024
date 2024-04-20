package calculator.operation;

import calculator.*;

import java.util.List;

/**
 * This class represents the boolean operation "IMPLICATION".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see Or
 * @see Not
 * @see Xor
 */
public class Implication<T> extends Operation<T> {
    /**
     * Class constructor specifying a number of Expressions to IMPLICATION.
     *
     * @param elist The list of Expressions to IMPLICATION
     * @throws IllegalConstruction    If an empty list of expressions is passed as parameter
     */
    public Implication(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        symbol = "=>";
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.implies(r);
    }
}
