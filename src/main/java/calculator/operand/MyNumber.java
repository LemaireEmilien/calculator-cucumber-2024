package calculator.operand;

import calculator.Expression;
import calculator.MyNaN;
import calculator.Value;
import calculator.operation.Operation;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * MyNumber is a concrete class that represents arithmetic numbers,
 * which are a special kind of Expressions, just like operations are.
 *
 * @see Expression
 * @see Operation
 */
@Slf4j
public class MyNumber extends Value<Integer> {


    /**
     * Constructor method
     *
     * @param v The integer value to be contained in the object
     */
    public /*constructor*/ MyNumber(int v) {
        super(v);
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    /**
     * Two MyNumber expressions are equal if the values they contain are equal
     *
     * @param o The object to compare to
     * @return A boolean representing the result of the equality test
     */
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof MyNumber)) {
            return false;
        }
        return Objects.equals(this.val, ((MyNumber) o).val);
        // Used == since the contained value is a primitive value
        // If it had been a Java object, .equals() would be needed
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
        return val;
    }

    @Override
    public Value<Integer> plus(Value<Integer> other) {
        return new MyNumber(this.getVal() + other.getVal());
    }

    @Override
    public Value<Integer> minus(Value<Integer> other) {
        return new MyNumber(this.getVal() - other.getVal());
    }

    @Override
    public Value<Integer> times(Value<Integer> other) {
        return new MyNumber(this.getVal() * other.getVal());
    }

    @Override
    public Value<Integer> div(Value<Integer> other) {
        return new MyNumber(this.getVal() / other.getVal());
    }

    @Override
    public Value<Integer> opposite() {
        return new MyNumber(-this.getVal());
    }

    @Override
    public Value<Integer> logarithm() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> naturalLog() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> squareRoot() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> sin() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> cos() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> tan() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> asin() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> acos() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> atan() {
        return new MyNaN<>();
    }

    @Override
    public Value<Integer> and(Value<Integer> other) {
        return this.getVal() != 0 && other.getVal() != 0 ? new MyNumber(1) : new MyNumber(0);
    }

    @Override
    public Value<Integer> or(Value<Integer> other) {
        return this.getVal() != 0 || other.getVal() != 0 ? new MyNumber(1) : new MyNumber(0);
    }

    @Override
    public Value<Integer> xor(Value<Integer> other) {
        return this.getVal() != 0 ^ other.getVal() != 0 ? new MyNumber(1) : new MyNumber(0);
    }

    @Override
    public Value<Integer> implies(Value<Integer> other) {
        return this.getVal() != 0 && other.getVal() == 0 ? new MyNumber(0) : new MyNumber(1);
    }

    @Override
    public Value<Integer> not() {
        log.info("Not {} : {}", this.getVal(),this.getVal()==0);
        return new MyNumber(this.getVal() == 0 ? 1 : 0);
    }

    @Override
    public Value<Integer> modulo(Value<Integer> other) {
        return new MyNumber(this.getVal() % other.getVal());
    }
}
