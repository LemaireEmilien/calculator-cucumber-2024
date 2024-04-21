package calculator.operand;

import calculator.Rational;
import calculator.Value;

import java.util.Random;

public class MyRational extends Value<Rational> {
    /**
     * Constructor method
     *
     * @param v The integer value to be contained in the object
     */
    public MyRational(Rational v) {
        super(v);
    }

    public MyRational(int numerator, int denominator) {
        super(new Rational(numerator, denominator));
    }

    public MyRational(int integer) {
        super(new Rational(integer, 1));
    }

    @Override
    public Value<Rational> plus(Value<Rational> other) {
        int td = this.val.denominator();
        int od = other.getVal().denominator();
        Rational r = new Rational(this.val.numerator() * od + other.getVal().numerator() * td,
                td * od);
        r = r.simplify();
        return new MyRational(r);
    }

    @Override
    public Value<Rational> minus(Value<Rational> other) {
        int td = this.val.denominator();
        int od = other.getVal().denominator();
        Rational r = new Rational(this.val.numerator() * od - other.getVal().numerator() * td,
                td * od);
        r = r.simplify();
        return new MyRational(r);
    }

    @Override
    public Value<Rational> times(Value<Rational> other) {
        int td = this.val.denominator();
        int od = other.getVal().denominator();
        Rational r = new Rational(this.val.numerator() * other.getVal().numerator(),
                td * od);
        r = r.simplify();
        return new MyRational(r);
    }

    @Override
    public Value<Rational> div(Value<Rational> other) {
        int td = this.val.denominator();
        int od = other.getVal().denominator();
        Rational r = new Rational(this.val.numerator() * od,
                td * other.getVal().numerator());
        r = r.simplify();
        return new MyRational(r);
    }

    @Override
    public Value<Rational> power(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> opposite() {
        return new MyRational(new Rational(-this.val.numerator(), this.val.denominator()));
    }

    @Override
    public Value<Rational> logarithm() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> naturalLog() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> squareRoot() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> sin() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> cos() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> tan() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> asin() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> acos() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> atan() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> and(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> or(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> xor(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> implies(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> not() {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> modulo(Value<Rational> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<Rational> rand(Random random) {
        return new MyNaN<>();
    }

    @Override
    public String toString() {
        return this.val.toString();
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
        if (!(o instanceof MyRational)) {
            return false;
        }
        return this.val.equals(((MyRational) o).getVal());
        // Used == since the contained value is a primitive value
        // If it had been a Java object, .equals() would be needed
    }

    @Override
    public int hashCode() {
        return this.val.hashCode();
    }

}
