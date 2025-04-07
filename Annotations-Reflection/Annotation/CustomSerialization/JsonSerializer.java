import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        boolean firstField = true;
        for (Field field : fields) {
            field.setAccessible(true);

            JsonField annotation = field.getAnnotation(JsonField.class);
            if (annotation != null) {
                if (!firstField) {
                    jsonBuilder.append(", ");
                }
                String key = annotation.name();
                Object value = field.get(obj);
                jsonBuilder.append("\"").append(key).append("\": \"").append(value).append("\"");
                firstField = false;
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

