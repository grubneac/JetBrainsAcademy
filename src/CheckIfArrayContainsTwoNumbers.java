import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
*Write a program that reads an unsorted array of integers and two numbers n and m. The program must check if n and m occur next to each other in the array (in any order).

Input data format

The first line contains the size of an array.
The second line contains elements of the array.
The third line contains two integer numbers n and m.
All numbers in the same line are separated by the space character.

Output data format

Only a single value: true or false.
* */
public class CheckIfArrayContainsTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        scanner.nextLine();

        Integer[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .toArray(size -> new Integer[size]);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        String str = Arrays.stream(arr)
                .map(String::valueOf)
                .collect(Collectors.joining());

        if ((str.indexOf("" + m + n) != -1) || (str.indexOf("" + n + m) != -1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
