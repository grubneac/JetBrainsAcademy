package skillvalue;
/// Code will not compile

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Question17 {
    public static List<Integer> numbers = Arrays.asList(1,2,3,4);

    public static void main(String[] args) {
        System.out.println(ListUtil.toString(numbers));
    }
}

class ListUtil {
    public static String toString(List<Integer> numbers) {
        StringJoiner sj = new StringJoiner(";", "[", "]");
        numbers.forEach((i) -> sj.add(i.toString()));
        return sj.toString();
    }
    public  String toString(List<Long> numbers) {
        StringJoiner sj = new StringJoiner(";", "[", "]");
        numbers.forEach((i) -> sj.add(i.toString()));
        return sj.toString();
    }
}
