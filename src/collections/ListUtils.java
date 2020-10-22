package collections;

import java.util.*;
import java.util.stream.Collectors;


class ListUtils {

    /**
     * It splits the passed list into a sequence of sublists with a predefined size
     */
    public static <T> List<List<T>> splitListIntoSubLists(List<T> list, int subListSize) {
        List<List<T>> sublists = new ArrayList<>();

        // write your code here
        int fromIndex = 0;
        int toIndex;
        for (int i = subListSize; i < list.size(); i += subListSize) {
            toIndex = i;
            sublists.add(list.subList(fromIndex, toIndex));
            fromIndex = toIndex;
        }
        toIndex = list.size();
        sublists.add(list.subList(fromIndex, toIndex));

        return sublists;
    }
}

/* Please, do not modify code in this class */
 class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] values = scanner.nextLine().split("\\s+");

        final List<Integer> list = Arrays.asList(values).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int subListSize = Integer.parseInt(scanner.nextLine());

        final List<List<Integer>> subLists = ListUtils.splitListIntoSubLists(list, subListSize);

        subLists.forEach(subList -> {
            final String representation = subList.stream().map(Object::toString).collect(Collectors.joining(" "));
            System.out.println(representation);
        });
    }
}