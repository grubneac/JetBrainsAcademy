import java.lang.reflect.Array;
import java.util.Scanner;

public class DoubleCharacters {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String inputStr = scanner.next();
//        System.out.println(doubleChar(inputStr));
        int[] a = new int[]{3, 0, 3, 9, 2, 1};

        int r=0;
        for (int i = 0; i <a.length ; i++) {
            if (a[i] < a.length)
                r += a[i];
        }

        System.out.println(r);

    }

    private static String doubleChar(String inputStr) {
        String result = "";

        for (char ch : inputStr.toCharArray()) {
            result += ch;
            result += ch;
        }

        return result;
    }
}
