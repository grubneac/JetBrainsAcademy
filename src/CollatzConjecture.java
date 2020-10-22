import java.util.Scanner;

public class CollatzConjecture {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String result = "";
        if (num == 1) {
            System.out.println(1);
            return;
        }
        do {
            result += num + " ";
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num += 1;
            }

        } while (num != 1);
        result += num;
        System.out.println(result);
    }
}
