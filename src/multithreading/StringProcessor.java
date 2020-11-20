package multithreading;
/*
Write a class with the name StringProcessor that extends the Thread class. The class must have a method that reads
strings (line by line) from the standard input. If a read string has a character in lower case, the processor must
output the string in the upper case; otherwise, the processor must output "FINISHED" and stop the processing.

Use the provided template for your class. Write any additional methods if you need them.

The testing system will start the processor as a regular thread.
*/
import java.util.Scanner;

public class StringProcessor extends Thread {
    public static void main(String[] args) {
        Thread thread = new StringProcessor();
        thread.start();
    }

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        while (true) {
            String inputStr = scanner.nextLine();
            String upperStr = inputStr.toUpperCase();
            if (inputStr.equals(upperStr)) {
                System.out.println("FINISHED");
                break;
            } else {
                System.out.println(upperStr);
            }
        }
    }
}
