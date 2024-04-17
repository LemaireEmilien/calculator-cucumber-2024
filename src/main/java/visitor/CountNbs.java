package visitor;

import calculator.Expression;
import calculator.Value;
import calculator.operation.Operation;
import lombok.Getter;

@Getter
public class CountNbs<T> extends Visitor<T> {

    private int nbs = 0;

    @Override
    public void visit(Value<T> n) {
        nbs += 1;
    }

    @Override
    public void visit(Operation<T> o) {
        for (Expression<T> a : o.getArgs()) {
            a.accept(this);
        }
    }
}
