import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CompatibleBoxes {
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CompatibleBoxes boxes = new CompatibleBoxes();

        Integer[] boxOne = boxes.scanBox(3);
        Integer[] boxTwo = boxes.scanBox(3);
        int[] compareResult = boxes.compareBox(boxOne, boxTwo);

        int max = 0;
        int min = 0;
        for (int forCompare :  compareResult) {
            if (max < forCompare) {
                max = forCompare;
            }
            if (min > forCompare) {
                min = forCompare;
            }
        }

        if (max == min) {
            System.out.println("generic.Box 1 = generic.Box 2");
        } else if (max == 1 && min == 0) {
            System.out.println("generic.Box 1 > generic.Box 2");
        } else if (min == -1 && max == 0) {
            System.out.println("generic.Box 1 < generic.Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }

    private int[] compareBox(Integer[] boxOne, Integer[] boxTwo) {
        int[] comparatorArray = new int[3];
        for (int i = 0; i < boxOne.length; i++) {
            if (boxOne[i] > boxTwo[i]) {
                //1 box1 > box2
                comparatorArray[i] = 1;
            } else if (boxOne[i] < boxTwo[i]) {
                // 2 box1 < box2
                comparatorArray[i] = -1;
            } else {
                // 3 box1 == box2
                comparatorArray[i] = 0;
            }
        }
        return comparatorArray;
    }

    private Integer[] scanBox(int count) {
        Integer[] arr = new Integer[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        return arr;
    }
}
