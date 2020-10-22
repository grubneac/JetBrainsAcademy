import java.util.Scanner;

public class IndexFfirstMax {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        int maxInt = Integer.MIN_VALUE;
        int indexMax = 0;
        int currInt = maxInt;
        for (int i = 0; i < counter; i++) {
            currInt = scanner.nextInt();
            if (maxInt < currInt) {
                maxInt = currInt;
                indexMax = i;
            }
        }
        System.out.println(indexMax);
    }
}
