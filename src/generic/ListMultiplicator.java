package generic;

import java.util.ArrayList;
import java.util.List;

/**
 Class to modify
 */
class ListMultiplicator {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        multiply(list, 3);

        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("four");

        multiply(list2 , 2);
        System.out.println(list2);
    }

    /**
     Repeats original list content provided number of times
     @param list list to repeat
     @param n times to repeat, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        // Add implementation here
        if (n == 0) {
            list.clear();
        } else {
            helperMultiply(list, n);
        }
    }

    public static <T> void helperMultiply(List<T> list, int n) {
        List<T> tmp = new ArrayList<>(list);
        for (int i = 0; i < n - 1; i++) {
            for (T t : tmp) {
                list.add(t);
            }
        }
    }

}