import java.util.Arrays;
import java.util.Scanner;

/*You are given coordinates of two queens on a chess board. Find out whether or not they hit each other.

Input data format

Four integer numbers x_1, y_1, x_2, y_2x

Output data format

Type "YES" (uppercase) if they hit each other or "NO" if they don't.
*/
public class ConditionalStatementQueens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] crd = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        if ((crd[0].equals(crd[2]) || crd[1].equals(crd[3]))
                || Math.abs(crd[0] - crd[2]) == Math.abs(crd[1] - crd[3])
        ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
