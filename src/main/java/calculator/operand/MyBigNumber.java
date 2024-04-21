package calculator.operand;

import calculator.Value;
import ch.obermuhlner.math.big.BigDecimalMath;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

@Slf4j
public class MyBigNumber extends Value<BigDecimal> {

    @Getter
    @Setter
    private static int precision = 10;

    public MyBigNumber(BigDecimal value) {
        super(value);
    }

    public MyBigNumber(int value) {
        super(BigDecimal.valueOf(value));
    }

    public MyBigNumber(double value) {
        super(BigDecimal.valueOf(value));
    }

    @Override
    public String toString() {
        //If the number is too big or too small to be displayed, it will be displayed in scientific notation
        if (val.abs().compareTo(new BigDecimal("1e10")) > 0) {
            String plainValue = val.stripTrailingZeros().toPlainString();
            int size = plainValue.length();
            BigDecimal plainValueDivBySize = val.movePointLeft(size - 1).setScale(getPrecision(), RoundingMode.HALF_UP).stripTrailingZeros();
            return plainValueDivBySize + "E+" + (size - 1);
        } else if (val.abs().compareTo(new BigDecimal("1e-10")) < 0) {
            return val.toString();
        } else {
            return val.setScale(getPrecision(), RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        }

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

        return Math.abs(this.val.doubleValue() - ((MyBigNumber) o).val.doubleValue()) < (Math.pow(10, -precision));
    }

    @Override
    public int hashCode() {
        return this.val.hashCode();
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
        //If the denominator is zero, return NaN
        if (other.getVal().compareTo(BigDecimal.ZERO) == 0) {
            return new MyNaN<>();
        }
        return new MyBigNumber(this.val.divide(other.getVal(), getPrecision(), RoundingMode.HALF_UP).stripTrailingZeros());
    }

    @Override
    public Value<BigDecimal> power(Value<BigDecimal> other) {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.pow(this.val, other.getVal(), mc));
    }

    @Override
    public Value<BigDecimal> opposite() {
        return new MyBigNumber(this.val.negate());
    }

    @Override
    public Value<BigDecimal> logarithm() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.log10(this.val, mc));
    }

    @Override
    public Value<BigDecimal> naturalLog() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.log(this.val, mc));
    }

    @Override
    public Value<BigDecimal> squareRoot() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.sqrt(this.val, mc));
    }

    @Override
    public Value<BigDecimal> sin() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.sin(this.val, mc));
    }

    @Override
    public Value<BigDecimal> cos() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.cos(this.val, mc));
    }

    @Override
    public Value<BigDecimal> tan() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.tan(this.val, mc));
    }

    @Override
    public Value<BigDecimal> asin() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.asin(this.val, mc));
    }

    @Override
    public Value<BigDecimal> acos() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.acos(this.val, mc));
    }

    @Override
    public Value<BigDecimal> atan() {
        MathContext mc = new MathContext(precision);
        return new MyBigNumber(BigDecimalMath.atan(this.val, mc));
    }

    @Override
    public Value<BigDecimal> and(Value<BigDecimal> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<BigDecimal> or(Value<BigDecimal> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<BigDecimal> xor(Value<BigDecimal> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<BigDecimal> implies(Value<BigDecimal> other) {
        return new MyNaN<>();
    }

    @Override
    public Value<BigDecimal> not() {
        return new MyNaN<>();
    }


    @Override
    public Value<BigDecimal> modulo(Value<BigDecimal> other) {
        return new MyNaN<>();
    }

    public Value<BigDecimal> rand(Random random) {
        return new MyBigNumber(random.nextDouble(this.getVal().doubleValue()));
    }

    public Value<BigDecimal> degToRad() {
        return new MyBigNumber(this.val.multiply(BigDecimal.valueOf(Math.PI)).divide(new BigDecimal(180), RoundingMode.HALF_UP));
    }

    public Value<BigDecimal> radToDeg() {
        return new MyBigNumber(this.val.multiply(new BigDecimal(180)).divide(BigDecimal.valueOf(Math.PI), RoundingMode.HALF_UP));
    }
}
