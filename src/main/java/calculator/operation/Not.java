package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Value;
import calculator.operand.MyNumber;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/** This class represents the boolean operation "NOT".
 * The class extends an abstract superclass Operation.
 * Other subclasses of Operation represent other arithmetic operations.
 * @see Operation
 * @see And
 * @see Or
 * @see Xor
 */
@Slf4j
public class Not<T> extends Operation<T> {


    /**
     * Class constructor specifying an Expression to NOT.
     *
     * @param elist The Expression to NOT
     */
    public Not(List<Expression<T>> elist) throws IllegalConstruction {
        super(elist);
        if (elist.size() > 1) throw new IllegalConstruction();
        symbol = "!";
        unary = true;
    }

    @Override
    public Value<T> op(Value<T> l, Value<T> r) {
        return l.not();
    }
}
