// do not remove imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class ArrayUtils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        invert(arr).forEach(s-> System.out.print(s+" "));


        ArrayList<Integer> arr2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));

        invert(arr2).forEach(s-> System.out.print(s+" "));
    }
    // define invert method here
    static <T> ArrayList<T> invert(ArrayList<T> inArr) {
        ArrayList<T> result = new ArrayList<T>();
        for (int i = inArr.size(); i > 0 ; i--) {
            result.add(inArr.get(i-1));
        }

        return  result;
    }
}