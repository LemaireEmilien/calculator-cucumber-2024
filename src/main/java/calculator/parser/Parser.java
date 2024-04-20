package calculator.parser;

import calculator.Expression;
import calculator.IllegalExpression;
import calculator.Value;
import calculator.operand.MyBigNumber;
import calculator.operand.MyNumber;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;

@NoArgsConstructor
@Slf4j
public class Parser<T> {

    public Expression<T> parse(String s, From<T> baseParser) throws IllegalExpression {
        CalculatorLexer lexer = new CalculatorLexer(CharStreams.fromString(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.init();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            log.error("Illegal expression : {}", s);
            throw new IllegalExpression();
        }
        VisitorParser<T> visitorParser = new VisitorParser<>(baseParser);
        try {
            Expression<T> expr = visitorParser.visit(tree);
            if (expr == null) {
                log.error("Illegal expression : {}", s);
                throw new IllegalExpression();
            }
            return expr;
        } catch (NullPointerException e) {
            log.error("Illegal expression : {}", s);
            throw new IllegalExpression();
        }
    }

    @FunctionalInterface
    public interface From<T> {
        Value<T> fromString(String s);
    }

    public static Value<Integer> stringToInteger(String s) {
        return new MyNumber(Integer.parseInt(s));
    }

    public static Value<BigDecimal> stringToBigDecimal(String s) {
        return new MyBigNumber(new BigDecimal(s));
    }

}
