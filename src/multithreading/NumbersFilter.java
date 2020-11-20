package multithreading;

import java.util.Scanner;

public class NumbersFilter extends Thread {
    public static void main(String[] args) {
        Thread t = new NumbersFilter();
        t.start();
    }

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        // implement this method
        int curInt;
        while (true) {
            curInt = scanner.nextInt();
            if (curInt == 0) {
                break;
            } else if (curInt % 2 == 0) {
                System.out.println(curInt);
            }
        }
    }
}
