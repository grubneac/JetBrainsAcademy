package arraysExemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindNearestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> listNum = readArrayList(scanner);
        int midNum = scanner.nextInt();

        ArrayList<Integer> result = new ArrayList<>();
        int maxNum = midNum;
        int minNum = midNum;
        for (Integer curNum : listNum) {
            if (curNum == midNum) {
                result.add(curNum);
            }
        }


        while (minNum > 0) {
            if (!result.isEmpty()) {
                break;
            }
            maxNum++;
            minNum--;
            for (Integer curNum : listNum) {
                if (curNum == minNum) {
                    result.add(curNum);
                }
            }
            for (Integer curNum : listNum) {
                if (curNum == maxNum) {
                    result.add(curNum);
                }
            }

        }

        for (Integer curNum : result) {
            System.out.print(curNum + " ");
        }


    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
