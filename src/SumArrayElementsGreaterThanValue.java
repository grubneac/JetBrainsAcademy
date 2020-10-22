import java.util.Arrays;
import java.util.Scanner;

public class SumArrayElementsGreaterThanValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray = scanner.nextInt(); scanner.nextLine();

        int[] arr ;//= new int[sizeArray];

        arr = Arrays.stream(scanner.nextLine()
                .split("\\s"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int maxParameter = scanner.nextInt();
        int summ = 0;
        for (int i : arr) {
            if (i > maxParameter) {
                summ += i;
            }
        }
        System.out.println(summ);
    }
}
