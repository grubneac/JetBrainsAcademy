package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ReadTxtFiles {
    public static void main(String[] args) {
        String fileName = "./src/files/text1.txt";
        File file = new File(fileName);


        try (Scanner scanner = new Scanner(file);) {

            int maxInt = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .mapToInt(v -> v)
                    .max().orElseThrow(NoSuchElementException::new);
            System.out.println(maxInt);


        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found!");

        }

    }

}
