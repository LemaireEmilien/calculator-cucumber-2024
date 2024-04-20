import calculator.Calculator;
import calculator.Expression;

public class Main {
    public static void main(String[] args) {
        Calculator<Integer> c = new Calculator<>();
        try {
            Expression<Integer> e = c.read("true & false & true");
            c.print(e);
            c.eval(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
