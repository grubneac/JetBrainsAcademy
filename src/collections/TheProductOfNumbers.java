package collections;
/*
Write a program that prints the product of all integer numbers from a to b (a < b).
Include a and exclude b from the product
*/
import java.util.OptionalLong;
import java.util.Scanner;
import java.util.stream.LongStream;

public class TheProductOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(LongStream.range(a, b).reduce(1,(x, y) -> x * y));

    }
}
