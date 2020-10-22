package collections;

import java.util.*;

public class GettingMaxElementOfStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = scanner.nextInt();
        scanner.nextLine();

        Deque<Integer> maxOrder = new ArrayDeque<>();
        int currNum;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < countCommands; i++) {
            String[] inputStrings = scanner.nextLine().split("\\s+");


            if (inputStrings[0].equals("push")) {
                currNum = Integer.valueOf(inputStrings[1]);
                if (currNum > maxNum || i == 0) {
                    maxNum = currNum;
                }
                maxOrder.push(maxNum);
            }
            if (inputStrings[0].equals("pop")) {
                maxOrder.pop();
                maxNum = maxOrder.peek();

            }
            if (inputStrings[0].equals("max")) {
                System.out.println(maxOrder.peek());
            }
        }
    }
}
