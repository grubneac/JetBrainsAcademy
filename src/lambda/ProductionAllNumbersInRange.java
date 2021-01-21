package lambda;
/*
Write a lambda expression that accepts two long arguments as a range borders and calculates (returns) product of all
  numbers in this range (inclusively). It's guaranteed that 0 <= left border <= right border.
If left border == right border then the result is any border.
* */
import java.util.function.LongBinaryOperator;

public class ProductionAllNumbersInRange {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        Long result = x;

        while (x != y) {
            result *= ++x;
        }
        return result;
    };

    public static void main(String[] args) {
        System.out.println(binaryOperator.applyAsLong(0, 1));
        System.out.println(binaryOperator.applyAsLong(2, 2));
        System.out.println(binaryOperator.applyAsLong(1, 4));
        System.out.println(binaryOperator.applyAsLong(5, 15));

    }
}
