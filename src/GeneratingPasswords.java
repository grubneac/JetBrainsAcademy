import java.util.Scanner;

public class GeneratingPasswords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        final int maxUpper = 90;
        final int minUpper = 65;
        final int maxLower = 122;
        final int minLower = 97;
        final int maxDig = 57;
        final int minDig = 48;

        String str = getRandomStringByRange(minUpper, maxUpper, a);
        str += getRandomStringByRange(minLower, maxLower, b);
        str += getRandomStringByRange(minDig, maxDig, c);
        str += getRandomStringByRange(minUpper, maxUpper, n - a - b - c);

        System.out.println(str);
    }

    private static String getRandomStringByRange(int minRange, int maxRange, int quantity) {
        String result = "";
        char randomSimbol;
        char prevRandomSimbol = '.';
        for (int i = 0; i < quantity; i++) {
            do {
                randomSimbol = (char) (minRange + (int) (Math.random() * ((maxRange - minRange) + 1)));
            } while (prevRandomSimbol == randomSimbol);

            prevRandomSimbol = randomSimbol;
            result += String.valueOf(randomSimbol);
        }

        return result;
    }

}
