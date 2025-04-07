package Annotation.RoleBased;

import java.lang.annotation.*;
import java.lang.reflect.*;

// 1. Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}