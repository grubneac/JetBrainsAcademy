package regEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllPasswords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here

        Pattern pattern = Pattern.compile("password[ :]+[a-zA-Z0-9]*\\b", Pattern.CASE_INSENSITIVE);
        Pattern pattern1 = Pattern.compile("password[ :]+", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(text);

        boolean flag = true;
        while (matcher.find()) {
//            System.out.println(matcher.group());
            flag = false;
            Matcher matcher1 = pattern1.matcher(matcher.group());
            if (matcher1.find()) {
                System.out.println(matcher.group().replace(matcher1.group(), ""));
            }
        }
        if (flag) {
            System.out.println("No passwords found.");
        }
    }

}
