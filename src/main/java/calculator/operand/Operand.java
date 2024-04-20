package calculator.operand;

import calculator.Value;

public interface Operand<T> {
    Value<T> plus(Value<T> other);

    Value<T> minus(Value<T> other);

    Value<T> times(Value<T> other);

    Value<T> div(Value<T> other);

    Value<T> opposite();

    Value<T> and(Value<T> other);

    Value<T> or(Value<T> other);

    Value<T> xor(Value<T> other);

    Value<T> implies(Value<T> other);
    
    Value<T> not();
}
