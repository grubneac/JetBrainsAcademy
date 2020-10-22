import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//Write a program that reads the list of integer numbers separated by spaces from the standard input
// and then remove all numbers with even indexes (0, 2, 4, and so on).
//
//After that, the program should output the resulting sequence in the reverse order.
public class FilteringTheList {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s"))
                .collect(Collectors.toList());
        List<Integer> result = IntStream.range(0, list.size())
                .filter(n -> n % 2 > 0)
                .mapToObj(list::get)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Collections.reverse(result);
        result.forEach(s -> System.out.print(s + " "));

    }
}
