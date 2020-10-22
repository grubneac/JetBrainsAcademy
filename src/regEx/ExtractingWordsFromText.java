package regEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractingWordsFromText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here

        Pattern pattern = Pattern.compile("\\bprogram\\w*\\b", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }
    }
}
