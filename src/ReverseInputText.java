import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Read an input text from the console and print its characters in reversed order.

Use Reader for collecting characters.

In this task, the input is limited by 50 characters. However, you are welcome to find a solution that does not depend on the input size, which may require some extra knowledge.
*/
public class ReverseInputText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuffer str = new StringBuffer(reader.readLine()).reverse();

        System.out.println(str);

        reader.close();
    }
}
