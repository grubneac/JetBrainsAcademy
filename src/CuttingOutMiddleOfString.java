import java.util.Scanner;

public class CuttingOutMiddleOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int lenText = text.length();
        if (lenText % 2 == 0) { //even
            if (lenText >= 4) {
                System.out.println(left(text, lenText / 2 - 1) + right(text, lenText / 2 - 1));
            } else {
                System.out.println("");
            }
        } else { //odd
            if (lenText >= 3) {
                System.out.println(left(text, lenText / 2) + right(text, lenText / 2));
            } else {
                System.out.println("");
            }
        }

    }


    private static String right(String text, int len) {
        int begIndex = text.length() - len;
        return text.substring(begIndex);
    }

    private static String left(String text, int len) {
        return text.substring(0, len);
    }
}
