package Collections.SetInterface;

import java.util.HashSet;
import java.util.Scanner;

public class SetsEqual {
    public static boolean checkEquality(HashSet<Integer> l1,HashSet<Integer> l2){
        if(l1.equals(l2)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set1=new HashSet<>();
        System.out.print("Enter number of elements in first set:");
        int n1=sc.nextInt();
        System.out.print("Enter elements of first set:");
        for(int i=0;i<n1;i++){
            set1.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in second set:");
        int n2=sc.nextInt();
        HashSet<Integer> set2=new HashSet<>();
        System.out.print("Enter elements of second set:");
        for(int i=0;i<n2;i++){
            set2.add(sc.nextInt());
        }
        boolean ifEqual=checkEquality(set1,set2);
        if(ifEqual){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
