import java.util.Scanner;

public class TheLengthOfTheSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        int counter = 0;
        do {
            num = scanner.nextInt();
            counter++;
        } while (0 != num);
        System.out.println(--counter);
    }
}
