package regEx;

import java.util.Scanner;

public class RemoveComments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeWithComments = scanner.nextLine();
        System.out.println(codeWithComments.replaceAll("(\\/\\*\\*\\/" +
                                                        "|\\/\\*[\\w\\s,=;]*[\\/\\*]*[\\w\\s,=;]*\\*\\/" +
                                                        "|\\/\\/.*$)", ""));
    }
}
