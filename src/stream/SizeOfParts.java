package stream;

import java.util.Scanner;
import java.util.stream.IntStream;

/*
A detector compares the size of parts produced by a machine with the reference standard.

If the size of the part is larger, it can be sent to be fixed, and the detector prints the number 1.
If the size of the part is smaller, it is removed as a reject, and the detector prints the number -1.
If the part is perfect, it is sent to the box with products, that are ready to ship, and the detector prints 0.

Write a program, which takes the number of parts n as input, and then the sequence of detector prints.
The program should output numbers in a single line containing the number of parts ready to be shipped,
the number of parts to be fixed, and the number of rejects.
*/
public class SizeOfParts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfParts = scanner.nextInt();
        int[] sizes = new int[3];
        IntStream.range(0, numberOfParts)
                .forEach(i -> {
                    int box = scanner.nextInt();
                    sizes[box + 1]++;
                });

        System.out.println(sizes[1] + " " + sizes[2] + " " + sizes[0]);
    }
}
