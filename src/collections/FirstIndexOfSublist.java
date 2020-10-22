package collections;

import java.util.*;
import java.util.stream.Collectors;

public class FirstIndexOfSublist {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> arrInt = Arrays.stream(scanner.nextLine().split(" "))
                .map(a -> Integer.valueOf(a))
                .collect(Collectors.toList());

        List<Integer> subArrInt = Arrays.stream(scanner.nextLine().split(" "))
                .map(a -> Integer.valueOf(a))
                .collect(Collectors.toList());
        int firstEntry = Collections.indexOfSubList(arrInt, subArrInt);
        int lastEntry = Collections.lastIndexOfSubList(arrInt, subArrInt);

        System.out.printf("%s %s", firstEntry, lastEntry);
    }
}
