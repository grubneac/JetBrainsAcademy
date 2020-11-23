import java.util.Scanner;
/*
 Snail creeps up the vertical pole of height H feet. It goes A feet up per day, and B feet down per night. In which day
 will the snail reach the top of the pole?

Input data format

On the input the program receives non-negative integers H, A, B, where H > B and A > B. Every integer does not exceed 100
* */
public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a >= h) {
            System.out.println(1);
        } else {
            int daylyPath = a - b;
            int counter = 1;
            while (true) {
                if (counter * daylyPath + a >= h) {
                    System.out.println(counter + 1);
                    break;
                } else {
                    counter++;
                }
            }
        }
    }
}
