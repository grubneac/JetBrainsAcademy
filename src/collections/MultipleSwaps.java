package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleSwaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listForSwap = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int swapCounter = scanner.nextInt();
        scanner.nextLine();

        List<Integer> indexOfSwapElement;
        for (int i = 0; i < swapCounter; i++) {
            indexOfSwapElement = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            Collections.swap(listForSwap, indexOfSwapElement.get(0), indexOfSwapElement.get(1));
        }

        listForSwap.forEach(a -> System.out.print(a + " "));

    }

}
