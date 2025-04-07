package junit;

public class ExceptionHandling {
    public int divide(int a,int b){
        if(b==0){
            throw new ArithmeticException("Divided by zero");
        }
        else{
            return a/b;
        }
    }
}
