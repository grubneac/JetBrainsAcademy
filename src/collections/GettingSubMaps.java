package collections;

import java.util.*;

public class GettingSubMaps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fromNum = scanner.nextInt();
        int toNum = scanner.nextInt();
        int sizeMap = scanner.nextInt();

        int key;
        String value;
        SortedMap<Integer, String> mainMap = new TreeMap<>();

        for (int i = 0; i < sizeMap; i++) {
            key = scanner.nextInt();
            value = scanner.next();
            mainMap.put(key, value);
        }

        mainMap.subMap(fromNum, toNum + 1).forEach((key2, value2) -> {
            System.out.println(key2 + " " + value2);
        });


    }
}
