import java.io.IOException;
import java.io.InputStream;
/*Read an input text from the console and print it as a sequence of bytes.
Use System.in as input stream directly. Avoid using Scanner.

Sample Input 1:
abc

Sample Output 1:
979899
*/
public class ConvertToBytes {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;

        byte[] b = inputStream.readAllBytes();

        for (byte b1 : b) {
            System.out.print(b1);
        }

    }
}
