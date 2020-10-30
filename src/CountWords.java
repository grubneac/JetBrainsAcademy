import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountWords {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String str = reader.readLine().trim();
        if (str.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(str.split("\\s+").length);
        }

        reader.close();
    }
}
