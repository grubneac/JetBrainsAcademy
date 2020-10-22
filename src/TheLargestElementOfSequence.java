import java.util.Scanner;

public class TheLargestElementOfSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int curr;
        int max = Integer.MIN_VALUE;
        do {
            curr = scanner.nextInt();
            if (max < curr) {
                max = curr;
            }
        } while (curr != 0);

        System.out.println(max);
    }
}
