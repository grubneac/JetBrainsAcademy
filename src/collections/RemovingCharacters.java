package collections;

import java.util.*;
import java.util.stream.Collectors;

public class RemovingCharacters {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int counter = 0;

        List<Character> firstWorld = readStingFromTerminal();
        List<Character> secondWorld = readStingFromTerminal();

        Map<Character, Integer> firstMap = computeChapters(firstWorld);
        Map<Character, Integer> secondMap = computeChapters(secondWorld);
        List<Character> forRemove = new ArrayList<>();

        for (Map.Entry entry : firstMap.entrySet()) {
            Character keyEntity = (Character) entry.getKey();
            forRemove.add(keyEntity);
            if (secondMap.containsKey(keyEntity)) { // count exist in both words char
                counter += Math.abs(firstMap.get(keyEntity) - secondMap.get(keyEntity));
            } else { // count char that exist only in first word
                counter += firstMap.get(keyEntity);
            }
        }
        // remove char that included in counter
        for (Character chr : forRemove) {
            secondMap.remove(chr);
        }

        for (Map.Entry entry : secondMap.entrySet()) {
            counter += (Integer) entry.getValue();
        }

        System.out.println(counter);

    }

    private static List<Character> readStingFromTerminal() {
        return scanner.nextLine()
                .toUpperCase()
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }

    private static Map<Character, Integer> computeChapters(List<Character> word) {
        Map<Character, Integer> result = new HashMap<>();
        for (Character chr : word) {
            if (result.containsKey(chr)) {
                int curNum = result.get(chr);
                result.put(chr, ++curNum);
            } else {
                result.put(chr, 1);
            }
        }
        return result;
    }
}
