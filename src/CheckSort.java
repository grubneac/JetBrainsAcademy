import java.util.Scanner;

public class CheckSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();

        int prevNum = Integer.MIN_VALUE;
        int currNum;
        for (int i = 0; i < counter; i++) {
            currNum = scanner.nextInt();
            if (i != 0) {
                if (prevNum > currNum) {
                    System.out.println("false");
                    return;
                }
            }
            prevNum = currNum;
        }
        System.out.println("true");
    }
}
