package calculator.parser;

import calculator.Expression;
import calculator.IllegalConstruction;
import calculator.operand.MyNumber;
import calculator.operation.*;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ParserRuleContext;

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
                case "cos" -> new Cos<>(insideExpression);
                case "sin" -> new Sin<>(insideExpression);
                case "tan" -> new Tan<>(insideExpression);
                case "acos" -> new Acos<>(insideExpression);
                case "asin" -> new Asin<>(insideExpression);
                case "atan" -> new Atan<>(insideExpression);
                case "log" -> new Logarithm<>(insideExpression);
                case "ln" -> new NaturalLog<>(insideExpression);
                case "sqrt" -> new SquareRoot<>(insideExpression);
                case "mod" -> new Modulo<>(insideExpression);
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
        } else {
            return visit(ctx.func_());
        }
    }

    @Override
    public Expression<T> visitBatom(CalculatorParser.BatomContext ctx) {
        if (ctx.boolean_expression() != null) {
            return visit(ctx.boolean_expression());
        }
        return (Expression<T>) new MyNumber(ctx.BOOLEAN().getText().equals("true") ? 1 : 0);
    }

    @Override
    public Expression<T> visitNotExpression(CalculatorParser.NotExpressionContext ctx) {
        if (ctx.children.size() == 1) {return visit(ctx.batom());}
        try {
            return new Not<>(List.of(visit(ctx.batom())));
        } catch (IllegalConstruction e) {
            log.error("Could not create Not operation");
            return null;
        }
    }

    @Override
    public Expression<T> visitAndExpression(CalculatorParser.AndExpressionContext ctx) {
        if (ctx.children.size() == 1) {return super.visitAndExpression(ctx);}
        return visitOperation(And.class, ctx.notExpression());
    }

    @Override
    public Expression<T> visitXorExpression(CalculatorParser.XorExpressionContext ctx) {
        if (ctx.children.size() == 1) return super.visitXorExpression(ctx);
        return visitOperation(Xor.class, ctx.andExpression());
    }

    @Override
    public Expression<T> visitOrExpression(CalculatorParser.OrExpressionContext ctx) {
        if (ctx.children.size() == 1) return super.visitOrExpression(ctx);
        return visitOperation(Or.class, ctx.xorExpression());
    }

    @Override
    public Expression<T> visitImplication(CalculatorParser.ImplicationContext ctx) {
        if (ctx.children.size() == 1) return super.visitImplication(ctx);
        return visitOperation(Implication.class, ctx.orExpression());
    }

    @Override
    public Expression<T> visitBoolean_expression(CalculatorParser.Boolean_expressionContext ctx) {
        return super.visitBoolean_expression(ctx);
    }

    private <O extends Operation<T>> Expression<T> visitOperation(Class<O> Operand, List<? extends ParserRuleContext> ctx) {
        try {
            List<Expression<T>> params = new ArrayList<>();
            for (var exp : ctx) {
                params.add(visit(exp));
            }
            return Operand.getDeclaredConstructor(List.class).newInstance(params);
        } catch (Exception e) {
            throw new RuntimeException("Could not create operation");
        }
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

    @Override
    public Expression<T> visitFunc_(CalculatorParser.Func_Context ctx) {
        log.trace("Visit func : {}", ctx.getText());
        String funcname = ctx.funcname().getText();

        List<Expression<T>> insideExpression = new ArrayList<>();
        for (var expr : ctx.expression()) {
            insideExpression.add(visit(expr));
        }

        return createOperation(funcname, insideExpression);
    }
}

