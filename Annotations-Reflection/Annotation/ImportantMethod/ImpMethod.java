package Annotation.ImportantMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Annotation.ImportantMethod.MarkImportant.ImportantMethod;
import Annotation.RepeatableAnnotation.BugReports;
import Annotation.RepeatableAnnotation.runMultiple.RunImmediately;

public class ImpMethod {
    @ImportantMethod(level="HIGH")
    public void imp1(){
        System.out.println("This is first important method");
    }
    @ImportantMethod(level="HIGH")
    public void imp2(){
        System.out.println("This is second important method");
    }
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ImpMethod im=new ImpMethod();
        for(Method method:im.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                method.invoke(im);
            }
        }
    }
}
