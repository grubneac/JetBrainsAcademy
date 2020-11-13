import java.util.Scanner;
/*Your task is to implement the getDayOfWeekName method that converts the number of the day of the week to its short name. If the given number is incorrect, the method should throw IllegalArgumentException.

Let's assume that a week starts from Monday:

1 → "Mon";
2 → "Tue";
3 → "Wed";
4 → "Thu";
5 → "Fri";
6 → "Sat";
7 → "Sun".
*/
public class ThrowingExceptionsDaysOfWeek {
    static String[] weeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static String getDayOfWeekName(int number) throws IllegalArgumentException {
        // write your code here
        try {
            return weeks[number - 1];
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}
