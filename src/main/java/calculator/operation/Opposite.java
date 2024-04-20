package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Value;

import java.util.List;

public class Opposite<T> extends Operation<T> {
    /**
     * To construct an operation with a list of expressions as arguments,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    public Opposite(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        if (elist.size() > 1) throw new IllegalConstruction();
        symbol = "-";
        unary = true;
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.opposite();
    }
}
