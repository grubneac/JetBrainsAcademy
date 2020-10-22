import java.util.*;
import java.util.stream.Collectors;

public class FindingTheMaxNumber {
    public static int findMaxByIterator(Iterator<Integer> iterator) {
        // write your code here
        int maxNum = Integer.MIN_VALUE;
        int curNum;
        while (iterator.hasNext()) {
            curNum = iterator.next();
            if (maxNum < curNum) {
                maxNum = curNum;
            }
        }
        return maxNum;
    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(findMaxByIterator(list.iterator()));
    }
}
