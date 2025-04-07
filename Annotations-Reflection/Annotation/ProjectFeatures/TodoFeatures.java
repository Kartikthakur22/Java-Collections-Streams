package Annotation.ProjectFeatures;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface TodoFeatures {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Todo{
        String task();
        String assignedTo();
        String priority() default "MEDIUM";
    }

}
