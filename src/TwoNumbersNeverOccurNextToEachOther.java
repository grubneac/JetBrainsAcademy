import java.util.Scanner;

public class TwoNumbersNeverOccurNextToEachOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int[] checkArr = new int[2];
        checkArr[0] = scanner.nextInt();
        checkArr[1] = scanner.nextInt();
        if (arraySize < 2) {
            System.out.println(true);
        } else {
            System.out.println(checkNeverOccur(array, checkArr));
        }

    }

    private static boolean checkNeverOccur(int[] array, int[] checkArr) {
        int prevNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if ((prevNum == checkArr[0] && array[i] == checkArr[1]) ||
                    (prevNum == checkArr[1] && array[i] == checkArr[0])) {
                return false;
            }
            prevNum = array[i];
        }

        return true;
    }
}
