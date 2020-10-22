package recursion;

import java.util.*;

public class NumberOfDecompositionsVer2 {
    static Set<String> result;
    static Comparator<String> stringComparator = new Comparator<String>() {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dim = scanner.nextInt();
        result = new TreeSet<>(stringComparator);

        partition(dim);
        result.forEach(e -> System.out.println(e));
        System.out.println("Total row: "+ result.size());
    }

    public static void partition(int n) {
        partition(n, n, "");
    }

    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            result.add(prefix.trim());
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n - i, i, prefix + " " + i);
        }
    }

}
