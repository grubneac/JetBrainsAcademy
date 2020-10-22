package collections;

import java.util.*;
import java.util.stream.Collectors;

public class SpellChecker {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int nKnownWords = scanner.nextInt();

        Set<String> listKnownWords = new HashSet<>();
        for (int i = 0; i < nKnownWords; i++) {
            listKnownWords.add(scanner.next());
        }

        int nText = scanner.nextInt();
        scanner.nextLine(); //  Consume newline left-over
        List<Set<String>> listTexts = new ArrayList<>();

        for (int i = 0; i < nText; i++) {
            listTexts.add(getListFromStream());
        }

        Set<String> errorTxt = new HashSet<>();

        // get only errors
        for (Set txt : listTexts) {
            errorTxt.addAll(removeAfromB(txt, listKnownWords));
        }

        //print errors
        for (String strError : errorTxt) {
            System.out.println(strError);
        }


    }

    private static Set<String> removeAfromB(Set<String> txt, Set<String> listKnownWords) {

        Set<String> result = new HashSet<>();
        result.addAll(txt);
        for (String str : txt) {
            for (String str2 : listKnownWords) {
                if (str.equalsIgnoreCase(str2)) {
                    result.remove(str);
                }
            }
        }
        return result;

    }

    private static Set<String> getListFromStream() {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}
