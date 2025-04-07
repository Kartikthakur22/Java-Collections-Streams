package Injection;

import java.lang.reflect.Field;

public class DIContainer {

    public static <T> T createInstance(Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = createInstance(field.getType());
                field.set(instance, dependency);
            }
        }

        return instance;
    }
}

