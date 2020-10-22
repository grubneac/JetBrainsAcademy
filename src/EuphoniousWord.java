import java.util.Scanner;

public class EuphoniousWord {
    static char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        char[] arr = num.toCharArray();
        int total = 0;
        int vowel = 0;
        int consonant = 0;
        for (char ar : arr) {
            if (isVowel(ar)) {
                vowel++;
                consonant = 0;
                if (vowel > 2) {
                    total++;
                    vowel -= 2;
                }
            } else {
                vowel = 0;
                consonant++;
                if (consonant > 2) {
                    total++;
                    consonant -= 2;
                }
            }
        }

        System.out.println(total);
    }

    private static boolean isVowel(char c) {

        for (char vow : vowels) {
            if (c == vow) {
                return true;
            }
        }
        return false;
    }
}
