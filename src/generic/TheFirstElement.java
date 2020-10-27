package generic;

public class TheFirstElement {


    public static void main(String[] args) {
        Integer[] array = new Integer[]{10, 6, 2, 3};
        System.out.println( getFirst(array));

        String[] array2 = new String[]{"one", "two", "three", "four"};
        System.out.println( getFirst(array2));
    }

    private static <T> T getFirst(T[] array) {
        T result = null;
        if (array.length > 0) {
            result = array[0];
        }

        return result;
    }
}
