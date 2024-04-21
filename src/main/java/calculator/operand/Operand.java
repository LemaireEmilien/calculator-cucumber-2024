package calculator.operand;

import calculator.Value;

import java.util.Random;

public interface Operand<T> {
    Value<T> plus(Value<T> other);

    Value<T> minus(Value<T> other);

    Value<T> times(Value<T> other);

    Value<T> div(Value<T> other);

    Value<T> power(Value<T> other);

    Value<T> opposite();

    Value<T> logarithm();

    Value<T> naturalLog();

    Value<T> squareRoot();

    Value<T> sin();

    Value<T> cos();

    Value<T> tan();

    Value<T> asin();

    Value<T> acos();

    Value<T> atan();

    Value<T> and(Value<T> other);

    Value<T> or(Value<T> other);

    Value<T> xor(Value<T> other);

    Value<T> implies(Value<T> other);

    Value<T> not();

    Value<T> modulo(Value<T> other);

    Value<T> rand(Random random);
}
