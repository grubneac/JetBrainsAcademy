package exceptionHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class ConvertingAndMultiplying {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        String sNum;
        while (true) {
            sNum = scanner.next();

            if ("0".equals(sNum)) {
                break;
            }
            arr.add(sNum);
        }
        int num;
        for (String s : arr) {
            try {
                num = Integer.parseInt(s);
                System.out.println(num * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + s);
            }

        }
    }
}
