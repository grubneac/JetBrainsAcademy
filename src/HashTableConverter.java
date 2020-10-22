public class HashTableConverter {
    public static void main(String[] args) {

        System.out.println(convertToHash(23) + " : "
                           + convertToHash(5) + " : "
                            + convertToHash(99));
    }

    private static int convertToHash(int v) {
        return v%13;
    }
}
