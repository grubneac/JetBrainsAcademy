package regEx;

import java.util.Scanner;

public class RemoveHTMLTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringWithHTMLTags = scanner.nextLine();
        System.out.println(stringWithHTMLTags.replaceAll("<[a-zA-Z0-9\\/-= \"]+>", ""));

    }

}
