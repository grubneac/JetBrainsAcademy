import java.io.CharArrayWriter;
import java.io.IOException;

public class ConvertToByteArray {
    public static void main(String[] args) throws IOException {
        String[] inputArr = new String[]{"This", " ", "is", " ", "a", " ", "test"};
        ConvertToByteArray cnv = new ConvertToByteArray();
        cnv.writeWords(inputArr);
    }

    public void writeWords(String[] words) throws IOException {
        LetterPrinter printer = new LetterPrinter();

        char[] letters = convert(words); // converting method
        for (char letter : letters) {
            printer.write(letter);
        }
    }

    public static char[] convert(String[] words) throws IOException {
        // implement the method
        CharArrayWriter caw = new CharArrayWriter();
        for (String str : words) {
            caw.write(str);
        }
        char[] result = caw.toCharArray();
        caw.close();
        return result;
    }
}

class LetterPrinter {
    public void write(char letter) {
        //implementation

    }
}
