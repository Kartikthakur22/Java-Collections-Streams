package AnnotationsRuntime;

import java.lang.annotation.*;

// Custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

