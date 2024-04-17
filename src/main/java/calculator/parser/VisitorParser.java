package calculator.parser;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.operation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VisitorParser<T> extends CalculatorBaseVisitor<Expression<T>> {

    private final Parser.From<T> baseParser;

    public VisitorParser(Parser.From<T> baseParser) {
        super();
        this.baseParser = baseParser;
    }

    private Expression<T> createOperation(String op, List<Expression<T>> insideExpression) {
        try {
            return switch (op) {
                case "*" -> new Times<>(insideExpression);
                case "/" -> new Divides<>(insideExpression);
                case "+" -> new Plus<>(insideExpression);
                case "-" -> new Minus<>(insideExpression);
                default -> {
                    log.warn("Could not create Operation");
                    yield null;
                }
            };
        } catch (IllegalConstruction e) {
            log.warn("Could not create Operation");
            return null;
        }
    }

    @Override
    public Expression<T> visitInit(CalculatorParser.InitContext ctx) {
        return visit(ctx.children.getFirst());
    }

    @Override
    public Expression<T> visitExpression(CalculatorParser.ExpressionContext ctx) {
        log.trace("Visit expression : {}", ctx.getText());

        if (ctx.children.size() == 1) {
            // multiplyingExpression
            return visit(ctx.multiplyingExpression());
        } else if (ctx.children.size() == 3) {
            // expression (PLUS | MINUS) multiplyingExpression
            List<Expression<T>> insideExpression = new ArrayList<>();
            insideExpression.add(visit(ctx.expression()));
            insideExpression.add(visit(ctx.multiplyingExpression()));

            String op = ctx.children.get(1).getText();
            return createOperation(op, insideExpression);
        }
        log.error("Illegal expression");
        return null;
    }

    @Override
    public Expression<T> visitMultiplyingExpression(CalculatorParser.MultiplyingExpressionContext ctx) {
        log.trace("Visit multiplying expression : {}", ctx.getText());

        if (ctx.children.size() == 1) {
            // powExpression
            return visit(ctx.powExpression());
        } else if (ctx.children.size() == 3) {
            // multiplyingExpression (TIMES | DIV) powExpression
            List<Expression<T>> insideExpression = new ArrayList<>();
            insideExpression.add(visit(ctx.multiplyingExpression()));
            insideExpression.add(visit(ctx.powExpression()));

            String op = ctx.children.get(1).getText();
            return createOperation(op, insideExpression);
        } else {
            List<Expression<T>> insideExpression = new ArrayList<>();
            for (var expr : ctx.expression()) {
                insideExpression.add(visit(expr));
            }
            return createOperation("*", insideExpression);
        }
    }

    @Override
    public Expression<T> visitPowExpression(CalculatorParser.PowExpressionContext ctx) {
        log.trace("Visit pow expression : {}", ctx.getText());

        if (ctx.children.size() == 1) {
            // signedAtom
            return visit(ctx.signedAtom());
        } else if (ctx.children.size() == 3) {
            // signedAtom POW powExpression
            // todo : add pow operation
            log.error("Exponent not yet implemented");
            return null;
        }
        log.error("Illegal powExpression");
        return null;
    }

    @Override
    public Expression<T> visitPostfix_expression(CalculatorParser.Postfix_expressionContext ctx) {
        log.trace("Visit postfix expression : {}", ctx.getText());

        if (ctx.children.size() == 1) {
            // postfix_multiplyingExpression
            return visit(ctx.signedAtom());
        } else {
            // LPAREN (postfix_multiplyingExpression COMMA?)+ RPAREN (PLUS | MINUS)
            List<Expression<T>> insideExpression = new ArrayList<>();
            for (var expr : ctx.postfix_expression()) {
                insideExpression.add(visit(expr));
            }

            String op = ctx.children.getLast().getText();
            return createOperation(op, insideExpression);
        }
    }

    @Override
    public Expression<T> visitPrefix_expression(CalculatorParser.Prefix_expressionContext ctx) {
        log.trace("Visit prefix multiplying expression : {}", ctx.getText());

        if (ctx.children.size() == 1) {
            // prefix_multiplyingExpression
            return visit(ctx.signedAtom());
        } else {
            // LPAREN (prefix_multiplyingExpression COMMA?)+ RPAREN (PLUS | MINUS)
            List<Expression<T>> insideExpression = new ArrayList<>();
            for (var expr : ctx.prefix_expression()) {
                insideExpression.add(visit(expr));
            }

            String op = ctx.children.getFirst().getText();
            return createOperation(op, insideExpression);
        }
    }

    @Override
    public Expression<T> visitSignedAtom(CalculatorParser.SignedAtomContext ctx) {
        String text = ctx.getText();
        log.trace("Visit signed atom expression : {}", text);

        if (ctx.func_() == null) {
            if (ctx.atom().LPAREN() != null) {
                return visit(ctx.atom().expression());
            }
            Expression<T> expr = visit(ctx.atom());
            if (ctx.MINUS() != null) {
                try {
                    expr = new Opposite<>(List.of(expr));
                } catch (IllegalConstruction e) {
                    expr = null;
                }
            }
            return expr;
        }
        // todo : add functions
        log.error("function not yet implemented");
        return null;
    }

    @Override
    public Expression<T> visitScientific(CalculatorParser.ScientificContext ctx) {
        String text = ctx.getText();
        log.trace("Visit signed atom scientific : {}", text);
        Expression<T> expr = baseParser.fromString(text);
        log.trace("base {}", expr);
        return expr;
    }

    @Override
    public Expression<T> visitRational(CalculatorParser.RationalContext ctx) {
        String text = ctx.getText();
        log.trace("Visit Rational : {}", text);
        Expression<T> expr = baseParser.fromString(text);
        log.trace("base {}", expr);
        return expr;
    }
}
