package calculator.operand;

import calculator.Expression;
import calculator.Value;
import calculator.operation.Operation;

import java.util.Objects;

import java.math.BigDecimal;

public class MyBigNumber extends Value<BigDecimal> {

    public MyBigNumber(BigDecimal v) {
        super(v);
    }


    @Override
    public String toString() {
        return null;
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
        return null;
    }

    @Override
    public Value<BigDecimal> minus(Value<BigDecimal> other) {
        return null;
    }

    @Override
    public Value<BigDecimal> times(Value<BigDecimal> other) {
        return null;
    }

    @Override
    public Value<BigDecimal> div(Value<BigDecimal> other) {
        return null;
    }

    @Override
    public Value<BigDecimal> opposite() {
        return null;
    }
}
