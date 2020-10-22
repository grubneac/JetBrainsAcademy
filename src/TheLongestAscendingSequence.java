import java.util.Scanner;

public class TheLongestAscendingSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt();
        scanner.nextLine();

        int currCounter = 0;
        int maxCounter = 0;
        int currNum;
        int prevNum = Integer.MIN_VALUE;
        for (int i = 0; i < sizeArray; i++) {

            currNum = scanner.nextInt();
            if (currNum > prevNum) {
                currCounter++;
            } else {
                if (maxCounter < currCounter) {
                    maxCounter = currCounter;
                }
                currCounter = 1;
            }
            prevNum = currNum;
        }
        if (maxCounter < currCounter) {
            maxCounter = currCounter;
        }
        System.out.println(maxCounter);

    }
}
