package calculator.operand;

import calculator.Value;

import java.util.Objects;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class MyBigNumber extends Value<BigDecimal> {

    private static final int precision = 10;

    public MyBigNumber(BigDecimal value) {
        super(value);
    }

    public MyBigNumber(int value) {
        super(BigDecimal.valueOf(value));
    }

    @Override
    public String toString() {
        return val.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyBigNumber)) {
            return false;
        }
        return Objects.equals(this.val, ((MyBigNumber) o).val);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Value<BigDecimal> plus(Value<BigDecimal> other) {
        return new MyBigNumber(this.val.add(other.getVal()));
    }

    @Override
    public Value<BigDecimal> minus(Value<BigDecimal> other) {
        return new MyBigNumber(this.val.subtract(other.getVal()));
    }

    @Override
    public Value<BigDecimal> times(Value<BigDecimal> other) {
        return new MyBigNumber(this.val.multiply(other.getVal()));
    }

    @Override
    public Value<BigDecimal> div(Value<BigDecimal> other) {
        return new MyBigNumber(this.val.divide(other.getVal(), precision, RoundingMode.HALF_UP));
    }

    @Override
    public Value<BigDecimal> opposite() {
        return new MyBigNumber(this.val.negate());
    }
}
