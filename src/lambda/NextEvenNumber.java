package lambda;
/*
Write a lambda expression that accepts a long value and returns a next even number.

It is guaranteed an input number is non-negative.
*/
import java.util.function.LongUnaryOperator;

public class NextEvenNumber {

    public static LongUnaryOperator unaryOperator = x -> {
        x++;
        if (x % 2 == 0) {
            return x;
        } else {
            return ++x;
        }
    };// Write your code here

    public static void main(String[] args) {
        System.out.println(unaryOperator.applyAsLong(3));
        System.out.println(unaryOperator.applyAsLong(10));
    }
}
