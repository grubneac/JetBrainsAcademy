import java.util.Scanner;

/*Write a program that reads the name of a city and checks if the name ends with "burg".
Keep in mind, a city can have a short name.
The program should output true or false.
*/
public class CheckBurgs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        String fourLastLetter = null;
        try {
            fourLastLetter = inputLine.substring(inputLine.length() - 4);
            if ("burg".equals(fourLastLetter)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("false");
        }


    }


}
