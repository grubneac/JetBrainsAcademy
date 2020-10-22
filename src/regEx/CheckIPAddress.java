package regEx;

import java.util.Scanner;

public class CheckIPAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ipNum = scanner.nextLine(); // a valid or invalid registration number

        /* write your code here */
        String ipNumReEx = "";
        for (int i = 0; i < 4; i++) {
            ipNumReEx += "([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])";
            if (i < 3) {
                ipNumReEx += "\\.";
            }
        }

        System.out.println(ipNum.matches(ipNumReEx) ? "YES" : "NO");
    }
}
