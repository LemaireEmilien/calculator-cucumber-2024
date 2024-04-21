package visitor;

import calculator.Expression;
import calculator.Value;
import calculator.operation.Not;
import calculator.operation.Operation;
import calculator.operation.Opposite;

import java.util.ArrayList;

/**
 * Evaluation is a concrete visitor that serves to
 * compute and evaluate the results of arithmetic expressions.
 */
public class Evaluator<T> extends Visitor<T> {

    /**
     * The result of the evaluation will be stored in this private variable
     */
    private Value<T> computedValue;

    /**
     * getter method to obtain the result of the evaluation
     *
     * @return an Integer object containing the result of the evaluation
     */
    public Value<T> getResult() {
        return computedValue;
    }

    /**
     * Use the visitor design pattern to visit a number.
     *
     * @param n The number being visited
     */
    public void visit(Value<T> n) {
        computedValue = n;
    }

    /**
     * Use the visitor design pattern to visit an operation
     *
     * @param o The operation being visited
     */
    public void visit(Operation<T> o) {
        ArrayList<Value<T>> evaluatedArgs = new ArrayList<>();
        //first loop to recursively evaluate each subexpression
        for (Expression<T> a : o.args) {
            a.accept(this);
            evaluatedArgs.add(computedValue);
        }
        //second loop to accumulate all the evaluated subresults
        Value<T> temp = evaluatedArgs.getFirst();
        int max = evaluatedArgs.size();
        if (o.isUnary()) {
            temp = o.op(temp, null);
        }
        for (int counter = 1; counter < max; counter++) {
            temp = o.op(temp, evaluatedArgs.get(counter));
        }
        // store the accumulated result
        computedValue = temp;
    }

}
