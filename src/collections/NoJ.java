package collections;

import java.util.*;

public class NoJ {

    public static void processIterator(String[] array) {
        // write your code here
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(array));

        ListIterator<String> iterator = strings.listIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.charAt(0) == 'J') {
                iterator.set(str.substring(1));
            } else {
                iterator.remove();
            }
        }
        Collections.reverse(strings);
        strings.forEach(System.out::println);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}