package lambda;

import java.util.function.DoubleUnaryOperator;

public class Operator {
    public static int a = 10;
    public static int b = 20;
    public static int c = 30;

    public static DoubleUnaryOperator unaryOperator = x -> {
        return a * x * x + b * x + c;
    }; // Write your code here

    public static void main(String[] args) {

        System.out.println(unaryOperator.applyAsDouble(3));
    }
}
