import java.util.Scanner;

public class ArmyUnits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldiers = scanner.nextInt();
        if (soldiers >= 1000) {
            System.out.println("legion");
        } else if (soldiers >= 250) {
            System.out.println("zounds");
        } else if (soldiers >= 20) {
            System.out.println("throng");
        } else if (soldiers >= 1) {
            System.out.println("pack");
        } else {
            System.out.println("no army");
        }
        ClassNotFoundException tt;
    }

}
