public class GettingInput {

    public static void main(String[] args) {
        System.out.println(getString());

    }
    public static String getString() {
        // write your code here
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String txt = scanner.nextLine();
        return "The input string: " + txt;
    }
}
