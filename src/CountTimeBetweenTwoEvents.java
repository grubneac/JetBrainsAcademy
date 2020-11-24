import java.util.Date;
import java.util.Scanner;

public class CountTimeBetweenTwoEvents {
    public static void main(String[] args) {
        long firstTime = new Date().getTime();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("exit")){
                break;
            }
            long secondTime = new Date().getTime();
            System.out.println(secondTime + " : " + firstTime + " = " + (secondTime - firstTime)/60000);
        }
    }
}
