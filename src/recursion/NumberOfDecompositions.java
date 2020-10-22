package recursion;

import java.util.*;
import java.util.stream.Collectors;

// don`t work correct
public class NumberOfDecompositions {
    static Set<String> result ;

    public static void main(String[] args) {
        // put your code here
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int[] arr1 = Arrays.stream(o1.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] arr2 = Arrays.stream(o2.split(" ")).mapToInt(Integer::parseInt).toArray();

                if (arr1.length <= arr2.length) {
                    for (int i = 0; i < arr1.length; i++) {
                        if (arr1[i] > arr2[i]) {
                            return 1;
                        } else if (arr1[i] < arr2[i]) {
                            return -1;
                        }
                    }
                    if (arr1.length == arr2.length) {
                        return 0;
                    }
                    return 1;
                } else {
                    for (int i = 0; i < arr2.length; i++) {
                        if (arr1[i] > arr2[i]) {
                            return 1;
                        } else if (arr1[i] < arr2[i]) {
                            return -1;
                        }
                    }
                    return -1;
                }
            }
        };
        result = new TreeSet<>(stringComparator);

        Scanner scanner = new Scanner(System.in);
        int dim = scanner.nextInt();
        List<Integer> arr = new LinkedList();
        for (int i = 0; i < dim; i++) {
            arr.add(1);
        }
        addToSet(arr);

        printArr();
    }

    private static void printArr() {
        result.forEach(e -> System.out.println(e));
        System.out.println("Total row: "+ result.size());
    }



    private static void addToSet(List<Integer> arr) {
        result.add(strFromIntArr(arr));
        if (arr.size() == 1) {
            return;
        }
        List<Integer> newArr = new LinkedList<>();
        for (int i = 1; i < arr.size(); i += 2) {
            newArr.add(arr.get(i) + arr.get(i - 1));
            List<Integer> newArrForSend = new LinkedList<>();
            newArrForSend.addAll(newArr);
            for (int j = i + 1; j < arr.size(); j++) {
                newArrForSend.add(arr.get(j));
            }
            addToSet(newArrForSend);
        }

    }

    private static String strFromIntArr(List<Integer> arr) {
        return arr.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));
    }
}
