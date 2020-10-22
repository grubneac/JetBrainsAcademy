package regEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InTheMiddleOfWord {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();


        Pattern javaPattern = Pattern.compile(".*[A-Za-z]" + part + "[A-Za-z].*", Pattern.CASE_INSENSITIVE);
        Matcher javaMatcher = javaPattern.matcher(line);


        System.out.println(javaMatcher.matches() ? "YES" : "NO");

    }
}

