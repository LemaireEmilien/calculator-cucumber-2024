package calculator;

import calculator.operand.MyBigNumber;
import calculator.operand.MyNaN;
import calculator.operand.MyNumber;
import calculator.operand.MyRational;
import calculator.operation.*;
import calculator.parser.Parser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorSteps {

//	static final Logger log = getLogger(lookup().lookupClass());

    private ArrayList<Expression<Integer>> params;
    private Operation<Integer> op;
    private Calculator<Integer> c;
    private Expression<Integer> e;

    private ArrayList<Expression<BigDecimal>> params_dec;
    private Operation<BigDecimal> op_dec;
    private Calculator<BigDecimal> c_dec;

    private ArrayList<Expression<Rational>> params_rat;
    private Operation<Rational> op_rat;
    private Calculator<Rational> c_rat;
    private Parser<Integer> parser;

    @Before
    public void resetMemoryBeforeEachScenario() {
        params = null;
        op = null;
        op_dec = null;
        c_dec = null;
        parser = new Parser<>();
        Rand.random.setSeed(0xCAFEBABEL);
    }

    @Given("I initialise a calculator")
    public void givenIInitialiseACalculator() {
        c = new Calculator<>();
        c_dec = new Calculator<>();
        c_rat = new Calculator<>();
    }

    @Given("an integer operation {string}")
    public void givenAnIntegerOperation(String s) {
        // Write code here that turns the phrase above into concrete actions
        params = new ArrayList<>(); // create an empty set of parameters to be filled in
        try {
            switch (s) {
                case "+" -> op = new Plus<>(params);
                case "-" -> op = new Minus<>(params);
                case "*" -> op = new Times<>(params);
                case "/" -> op = new Divides<>(params);
                case "&" -> op = new And<>(params);
                case "|" -> op = new Or<>(params);
                case "^" -> op = new Xor<>(params);
                case "=>" -> op = new Implication<>(params);
                case "!" -> op = new Not<>(params);
                case "mod" -> op = new Modulo<>(params);
                case "rand" -> op = new Rand<>(params);
                case "**" -> op = new Power<>(params);
                case "log" -> op = new Logarithm<>(params);
                case "ln" -> op = new NaturalLog<>(params);
                case "sqrt" -> op = new SquareRoot<>(params);
                case "cos" -> op = new Cos<>(params);
                case "sin" -> op = new Sin<>(params);
                case "tan" -> op = new Tan<>(params);
                case "acos" -> op = new Acos<>(params);
                case "asin" -> op = new Asin<>(params);
                case "atan" -> op = new Atan<>(params);
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("a rational operation {string}")
    public void givenARationalOperation(String s) {
        // Write code here that turns the phrase above into concrete actions
        params_rat = new ArrayList<>(); // create an empty set of parameters to be filled in
        try {
            switch (s) {
                case "+" -> op_rat = new Plus<>(params_rat);
                case "-" -> op_rat = new Minus<>(params_rat);
                case "*" -> op_rat = new Times<>(params_rat);
                case "/" -> op_rat = new Divides<>(params_rat);
                case "log" -> op_rat = new Logarithm<>(params_rat);
                case "ln" -> op_rat = new NaturalLog<>(params_rat);
                case "sqrt" -> op_rat = new SquareRoot<>(params_rat);
                case "cos" -> op_rat = new Cos<>(params_rat);
                case "sin" -> op_rat = new Sin<>(params_rat);
                case "tan" -> op_rat = new Tan<>(params_rat);
                case "acos" -> op_rat = new Acos<>(params_rat);
                case "asin" -> op_rat = new Asin<>(params_rat);
                case "atan" -> op_rat = new Atan<>(params_rat);
                case "rand" -> op_rat = new Rand<>(params_rat);
                case "**" -> op_rat = new Power<>(params_rat);
                case "&" -> op_rat = new And<>(params_rat);
                case "|" -> op_rat = new Or<>(params_rat);
                case "^" -> op_rat = new Xor<>(params_rat);
                case "=>" -> op_rat = new Implication<>(params_rat);
                case "!" -> op_rat = new Not<>(params_rat);
                case "mod" -> op_rat = new Modulo<>(params_rat);

                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("a real operation {string}")
    public void givenARealOperation(String s) {
        // Write code here that turns the phrase above into concrete actions
        params_dec = new ArrayList<>(); // create an empty set of parameters to be filled in
        try {
            switch (s) {
                case "+" -> op_dec = new Plus<>(params_dec);
                case "-" -> op_dec = new Minus<>(params_dec);
                case "*" -> op_dec = new Times<>(params_dec);
                case "/" -> op_dec = new Divides<>(params_dec);
                case "log" -> op_dec = new Logarithm<>(params_dec);
                case "ln" -> op_dec = new NaturalLog<>(params_dec);
                case "sqrt" -> op_dec = new SquareRoot<>(params_dec);
                case "cos" -> op_dec = new Cos<>(params_dec);
                case "sin" -> op_dec = new Sin<>(params_dec);
                case "tan" -> op_dec = new Tan<>(params_dec);
                case "acos" -> op_dec = new Acos<>(params_dec);
                case "asin" -> op_dec = new Asin<>(params_dec);
                case "atan" -> op_dec = new Atan<>(params_dec);
                case "rand" -> op_dec = new Rand<>(params_dec);
                case "**" -> op_dec = new Power<>(params_dec);
                case "&" -> op_dec = new And<>(params_dec);
                case "|" -> op_dec = new Or<>(params_dec);
                case "^" -> op_dec = new Xor<>(params_dec);
                case "=>" -> op_dec = new Implication<>(params_dec);
                case "!" -> op_dec = new Not<>(params_dec);
                case "mod" -> op_dec = new Modulo<>(params_dec);
                default -> fail();
            }
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    // The following example shows how to use a DataTable provided as input.
    // The example looks slightly complex, since DataTables can take as input
    //  tables in two dimensions, i.e. rows and lines. This is why the input
    //  is a list of lists.
    @Given("the following list of integer numbers")
    public void givenTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        // Since we only use one line of input, we use get(0) to take the first line of the list,
        // which is a list of strings, that we will manually convert to integers:
        numbers.getFirst().forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        params.forEach(n -> System.out.println("value =" + n));
        op = null;
    }

    // The string in the Given annotation shows how to use regular expressions...
    // In this example, the notation d+ is used to represent numbers, i.e. nonempty sequences of digits
    @Given("^the sum of two numbers (\\d+) and (\\d+)$")
    // The alternative, and in this case simpler, notation would be:
    // @Given("the sum of two numbers {int} and {int}")
    public void givenTheSum(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Plus<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the product of two numbers (\\d+) and (\\d+)$")
    public void givenTheProduct(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Times<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the difference of two numbers (\\d+) and (\\d+)$")
    public void givenTheDifference(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Minus<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the quotient of two numbers (\\d+) and (\\d+)$")
    public void givenTheQuotient(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Divides<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the negation of a number (\\d+)$")
    public void givenTheNegation(int n) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n));
            op = new Not<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Then("^its (.*) notation is (.*)$")
    public void thenItsNotationIs(String notation, String s) {
        if (notation.equals("PREFIX") || notation.equals("POSTFIX") || notation.equals("INFIX")) {
            assertEquals(s, op.toString(Notation.valueOf(notation)));
        } else fail(notation + " is not a correct notation! ");
    }

    @When("^I provide a (.*) integer number (\\d+)$")
    public void whenIProvideANumber(String s, int val) {
        //add extra parameter to the operation
        params = new ArrayList<>();
        params.add(new MyNumber(val));
        op.addMoreParams(params);
    }

    @When("^I provide a NaN$")
    public void whenIProvideANaN() {
        //add extra parameter to the operation
        params = new ArrayList<>();
        params.add(new MyNaN<>());
        op.addMoreParams(params);
    }

    @When("^I provide a (.*) decimal number (\\d+.\\d*)$")
    public void whenIProvideANumber(String s, float val) {
        //add extra parameter to the operation
        params_dec = new ArrayList<>();
        params_dec.add(new MyBigNumber(BigDecimal.valueOf(val)));
        op_dec.addMoreParams(params_dec);
    }

    @When("I provide a rational number {int} over {int}")
    public void whenIProvideARationalNumber(int val, int v2) {
        //add extra parameter to the operation
        params_rat = new ArrayList<>();
        params_rat.add(new MyRational(val, v2));
        op_rat.addMoreParams(params_rat);
    }

    @When("I provide two rational number {int} over {int}")
    public void iProvideTwoRationalNumberNOverN(int val, int v1) {
        params_rat = new ArrayList<>();
        params_rat.add(new MyRational(val, 1));
        params_rat.add(new MyRational(v1, 1));
        op_rat.addMoreParams(params_rat);
    }

    @Then("^the (.*) is (\\d+)$")
    public void thenTheOperationIs(String s, int val) {
        try {
            switch (s) {
                case "sum" -> op = new Plus<>(params);
                case "product" -> op = new Times<>(params);
                case "quotient" -> op = new Divides<>(params);
                case "difference" -> op = new Minus<>(params);
                default -> fail();
            }
            assertEquals(new MyNumber(val), c.eval(op));
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Then("the operation evaluates to the integer {int}")
    public void thenTheOperationEvaluatesTo(int val) {
        assertEquals(new MyNumber(val), c.eval(op));
    }

    @Then("the operation evaluates to the decimal {double}")
    public void thenTheOperationEvaluatesTo(double val) {
        MyBigNumber.setPrecision(5);
        assertEquals(new MyBigNumber(BigDecimal.valueOf(val)), c_dec.eval(op_dec));
    }

    @Then("the operation evaluates to NaN")
    public void thenTheOperationEvaluatesToNaN() {
        assertEquals(new MyNaN<>(), c.eval(op));
    }

    @Then("the decimal operation evaluates to NaN")
    public void thenTheDecimalOperationEvaluatesToNaN() {
        assertEquals(new MyNaN<>(), c_dec.eval(op_dec));
    }

    @Then("the rational operation evaluates to NaN")
    public void theRationalOperationEvaluatesToNaN() {
        assertEquals(new MyNaN<>(), c_rat.eval(op_rat));
    }

    @Then("the expression evaluates to {}")
    public void theExpressionEvaluatesTo(String result) {
        assertEquals(new MyNumber(Integer.parseInt(result)), c.eval(e));
    }

    @When("I provide an expression {}")
    public void iProvideAnExpression(String s) {
        try {
            e = parser.parse(s, Parser::stringToInteger);
        } catch (IllegalExpression e) {
            fail();
        }
    }

    @Given("^the and of two numbers (\\d+) and (\\d+)$")
    public void givenTheAnd(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new And<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the or of two numbers (\\d+) and (\\d+)$")
    public void givenTheOr(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Or<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }

    @Given("^the xor of two numbers (\\d+) and (\\d+)$")
    public void givenTheXor(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Xor<>(params);
        } catch (IllegalConstruction e) {
            fail();
        }
    }


}
