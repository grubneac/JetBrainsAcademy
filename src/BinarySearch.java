import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6,  8, 9};

        int key = 7;
        System.out.println(Arrays.binarySearch(arr, key));
        System.out.println(callBinarySearch(arr, key));
    }

    /**
     * @param nums ordered sequence of integers
     * @param key  an element for searching
     * @return index of key or a negative value
     */
    public static int callBinarySearch(int[] nums, int key) {
        // write your code here
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            } else if (nums[i] > key){
                return -1 * (i+1);
            }
        }
        if (nums.length > 0) {
            return -1 * (nums.length+1);
        } else {
            return -1;
        }
    }
}
