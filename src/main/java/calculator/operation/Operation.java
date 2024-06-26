package calculator.operation;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.Notation;
import calculator.Value;
import calculator.operand.MyNumber;
import lombok.Getter;
import visitor.Printer;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation is an abstract class that represents arithmetic operations,
 * which are a special kind of Expressions, just like numbers are.
 *
 * @see Expression
 * @see MyNumber
 */
@Getter
public abstract class Operation<T> implements Expression<T> {
    /**
     * The list of expressions passed as an argument to the arithmetic operation
     * -- GETTER --
     * getter method to return the number of arguments of an arithmetic operation.
     */
    public final List<Expression<T>> args;

    /**
     * The character used to represent the arithmetic operation (e.g. "+", "*")
     */
    protected String symbol;

    protected boolean unary = false;

    /**
     * To construct an operation with a list of expressions as arguments,
     * as well as the Notation used to represent the operation.
     *
     * @param elist The list of expressions passed as argument to the arithmetic operation
     * @throws IllegalConstruction Exception thrown if a null list of expressions is passed as argument
     */
    protected /*constructor*/ Operation(List<Expression<T>> elist)
            throws IllegalConstruction {
        if (elist == null) {
            throw new IllegalConstruction();
        } else {
            args = new ArrayList<>(elist);
        }
    }

    /**
     * Abstract method representing the actual binary arithmetic operation to compute
     *
     * @param l first argument of the binary operation
     * @param r second argument of the binary operation
     * @return result of computing the binary operation
     */
    public abstract Value<T> op(Value<T> l, Value<T> r);
    // the operation itself is specified in the subclasses

    /**
     * Add more parameters to the existing list of parameters
     *
     * @param params The list of parameters to be added
     */
    public void addMoreParams(List<Expression<T>> params) {
        args.addAll(params);
    }

    /**
     * Accept method to implement the visitor design pattern to traverse arithmetic expressions.
     * Each operation will delegate the visitor to each of its arguments expressions,
     * and will then pass itself to the visitor object to get processed by the visitor object.
     *
     * @param v The visitor object
     */
    public void accept(Visitor<T> v) {
        v.visit(this);
    }

    /**
     * Convert the arithmetic operation into a String to allow it to be printed,
     * using the default notation (prefix, infix or postfix) that is specified in some variable.
     *
     * @return The String that is the result of the conversion.
     */
    @Override
    public final String toString() {
        return toString(Notation.INFIX);
    }

    /**
     * Convert the arithmetic operation into a String to allow it to be printed,
     * using the notation n (prefix, infix or postfix) that is specified as a parameter.
     *
     * @param n The notation to be used for representing the operation (prefix, infix or postfix)
     * @return The String that is the result of the conversion.
     */
    public final String toString(Notation n) {
        Printer<T> p = new Printer<>(n);
        this.accept(p);
        return p.getResult();
    }

    /**
     * Two operation objects are equal if their list of arguments is equal and they correspond to the same operation.
     *
     * @param o The object to compare with
     * @return The result of the equality comparison
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false; // No object should be equal to null

        if (this == o) return true; // If it's the same object, they're obviously equal

        if (getClass() != o.getClass())
            return false; // getClass() instead of instanceof() because an addition is not the same as a multiplication

        Operation<T> other = (Operation<T>) o;
        return this.args.equals(other.getArgs());
    }

    /**
     * The method hashCode needs to be overridden it the equals method is overridden;
     * otherwise there may be problems when you use your object in hashed collections
     * such as HashMap, HashSet, LinkedHashSet.
     *
     * @return The result of computing the hash.
     */
    @Override
    public int hashCode() {
        int result = 5;
        int prime = 31;
        result = prime * result + symbol.hashCode();
        result = prime * result + args.hashCode();
        return result;
    }
}
