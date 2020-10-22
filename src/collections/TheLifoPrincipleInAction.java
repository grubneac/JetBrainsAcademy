package collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public interface TheLifoPrincipleInAction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        List<Integer> arr = new LinkedList<>();

        for (int i = 0; i < arrSize; i++) {
            arr.add(scanner.nextInt());
        }

        Collections.reverse(arr);

        arr.forEach(System.out::println);
    }
}
