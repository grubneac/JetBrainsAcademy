import java.util.Scanner;

public class LuckyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        String[] numArr = num.split("");
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < numArr.length; i++) {
            if (i < 3) {
                firstSum += Integer.parseInt(numArr[i]);
            } else {
                secondSum += Integer.parseInt(numArr[i]);
            }
        }
        if (firstSum == secondSum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
