package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */

public class ManipulatingFieldsAndMethodsFieldValue {
}

class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Field[] fields = object.getClass().getFields();

        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers()) && field.getName().equals(fieldName)) {
                return field.get(object);
            }
        }
        return null;
    }

}