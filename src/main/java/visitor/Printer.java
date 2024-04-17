package visitor;

import calculator.Expression;
import calculator.Notation;
import calculator.Value;
import calculator.operation.Operation;
import calculator.operation.Opposite;

/**
 * Evaluation is a concrete visitor that serves to
 * compute and evaluate the results of arithmetic expressions.
 */
public class Printer<T> extends Visitor<T> {

    private final Notation n;
    /**
     * The result of the evaluation will be stored in this private variable
     */
    private final StringBuilder result;

    /**
     * Default constructor of the class. Does not initialise anything.
     */
    public Printer(Notation n) {
        this.n = n;
        this.result = new StringBuilder();
    }

    /**
     * getter method to obtain the result of the evaluation
     *
     * @return an Integer object containing the result of the evaluation
     */
    public String getResult() {
        return result.toString();
    }

    /**
     * Use the visitor design pattern to visit a number.
     *
     * @param n The number being visited
     */
    public void visit(Value<T> n) {
        result.append(n.getVal());
    }

    /**
     * Use the visitor design pattern to visit an operation
     *
     * @param o The operation being visited
     */
    public void visit(Operation<T> o) {
        if (n.equals(Notation.PREFIX) || o instanceof Opposite<T>) {
            result.append(o.getSymbol());
        }
        result.append("(");

        //first loop to recursively evaluate each subexpression
        for (int i = 0; i < o.args.size(); i++) {
            Expression<T> e = o.args.get(i);
            e.accept(this);
            if (i < o.args.size() - 1) {
                if (n.equals(Notation.INFIX)) {
                    result.append(" %s ".formatted(o.getSymbol()));
                } else {
                    result.append(", ");
                }

            }
        }
        result.append(")");
        if (n.equals(Notation.POSTFIX)) {
            result.append(o.getSymbol());
        }

    }

}
