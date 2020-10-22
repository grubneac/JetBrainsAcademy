package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueAndStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        int curNum;
        for (int i = 0; i < counter; i++) {
            curNum = scanner.nextInt();

            if (curNum % 2 == 0) { //even
                deque.addFirst(curNum);

            } else { //odd
                deque.addLast(curNum);
            }
        }
        deque.forEach(System.out::println);
    }
}
