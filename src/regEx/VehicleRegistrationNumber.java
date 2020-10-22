package regEx;

import java.util.Scanner;

public class VehicleRegistrationNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNum = scanner.nextLine(); // a valid or invalid registration number

        /* write your code here */
        String regNumReEx = "[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}";
        System.out.println(regNum.matches(regNumReEx));
    }
}
