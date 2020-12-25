package jUnit;

public class Calculator {
    private final CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
        this.engine = engine;
    }

    public String divide(int a, int b) {
        // implement me
        try {
            return String.format("Division of %d by %d = %d", a, b, engine.divide(a, b));
        } catch (ArithmeticException e) {
            return "Division by zero is prohibited";
        }
    }
}
