package calculator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public record Rational(int numerator, int denominator) {
    public Rational simplify() {
        int gcd = gcd(numerator, denominator);
        return new Rational(this.numerator / gcd, this.denominator / gcd);

    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        if (this.denominator == 1) {
            return this.numerator + "";
        }
        return this.numerator() + "⁄" + this.denominator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rational rational = (Rational) o;

        return new EqualsBuilder().append(numerator, rational.numerator).append(denominator, rational.denominator).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(numerator).append(denominator).toHashCode();
    }
}


