package regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindManyTime {

    public static void main(String[] args) {
        String str = "\"@attr1\":null,\"@attr2\":\"\",\"#root2\":null";

        Pattern pattern = Pattern.compile("\"[a-zA-Z0-9@#]+\":(\"[a-zA-Z0-9@#]*\"|null)");

        Matcher matcher = pattern.matcher(str.replace(" ",""));
        int startNext = 0;
        while (matcher.find(startNext)) {
            System.out.println( matcher.start()+ " : " + matcher.group() + " : " + matcher.end());
            startNext = matcher.end()+1;
        }

    }



}
