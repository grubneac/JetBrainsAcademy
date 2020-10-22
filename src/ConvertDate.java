import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConvertDate {

    public static void main(String[] args) {
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd", new Locale("ru", "RU"));
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MM/dd/yyyy", new Locale("ru", "RU"));

        Scanner scanner = new Scanner(System.in);
        String sDate = scanner.next();

        Date currDate = null;
        try {
            currDate = dateFormatIn.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateFormatOut.format(currDate));
    }
}
