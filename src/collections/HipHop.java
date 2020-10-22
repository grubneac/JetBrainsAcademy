package collections;

import java.util.*;
import java.util.stream.Collectors;

public class HipHop {

    public static void iterateOverList(ListIterator<String> iter) {
        // write your code here
        while (iter.hasNext()) {
            String str = iter.next();
            if ("Hip".equals(str)) {
                iter.add("Hop");
            }
        }
    }

    public static void printList(ListIterator<String> iter) {
        // write your code here
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        iterateOverList(list.listIterator());
        printList(list.listIterator());
    }
}