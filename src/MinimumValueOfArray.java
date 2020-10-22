import java.util.Scanner;

public class MinimumValueOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int currMin;
        for (int i = 0; i < size; i++) {
            currMin = scanner.nextInt();
            if (currMin < min) {
                min = currMin;
            }
        }

        System.out.println(min);

    }
}
