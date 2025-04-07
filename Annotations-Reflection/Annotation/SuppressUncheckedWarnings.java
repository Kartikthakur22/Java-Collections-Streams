package Annotation;

import java.util.ArrayList;

public class SuppressUncheckedWarnings {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList list = new ArrayList(); 

        list.add("Hello");
        list.add(42);
        list.add(3.14);

        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
