package reflection;
/**
 Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DealingWithModifiersListPrivateFields {

    public static void main(String[] args) {
        List<String> tt = new DealingWithModifiersListPrivateFields().getPrivateFields(new LinkedList());
        for (String s : tt) {
            System.out.println(s);
        }
    }

    public List<String> getPrivateFields(Object object) {
        // Add implementation here
        List<String> result = new LinkedList<>();

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {

            if (Modifier.isPrivate(field.getModifiers())) {
                result.add(field.getName());
            }
        }
        Collections.sort(result);
        return result;
    }
}
