package calculator;

public class MyNaN<T> extends Value<T> {
    /**
     * Constructor method
     */
    public MyNaN() {
        super(null);
    }

    @Override
    public String toString() {
        return "NaN";
    }

    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is of another type then return false
        return o instanceof MyNaN;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Value<T> plus(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> minus(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> times(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> div(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> opposite() {
        return null;
    }

    @Override
    public Value<T> and(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> or(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> xor(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> implies(Value<T> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<T> not() {
        return null;
    }
}
