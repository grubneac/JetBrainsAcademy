import java.util.Scanner;
/*
 Write a program that reads an array of ints and outputs the maximum product of two adjacent elements in
 the given array of non-negative numbers.

Input data format

The first line of the input contains the number of elements in the array.
The second line contains the elements of the array separated by spaces.
The array always has at least two elements.
 */

public class TheMaximumProductOfAdjacentElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = scanner.nextInt();
        int[] arrayInt = new int[counter];
        for (int i = 0; i < counter; i++) {
            arrayInt[i] = scanner.nextInt();
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < counter; i++) {
            long curLong = arrayInt[i - 1] * arrayInt[i];
            if (curLong > max)
                max = curLong;
        }
        System.out.println(max);
    }
}
