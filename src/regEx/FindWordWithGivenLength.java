package regEx;

import java.util.*;
import java.util.regex.*;

public class FindWordWithGivenLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Pattern javaPattern = Pattern.compile("([^A-Za-z]+[A-Za-z]{" + size + "}[^A-Za-z]+" +
                "|^[A-Za-z]{" + size + "}[^A-Za-z]+" +
                "|[^A-Za-z]+[A-Za-z]{" + size + "}$)");
        

        Matcher javaMatcher = javaPattern.matcher(line);


        System.out.println(javaMatcher.find() ? "YES" : "NO");
    }
}
