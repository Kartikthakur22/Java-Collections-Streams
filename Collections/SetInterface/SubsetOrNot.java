package Collections.SetInterface;

import java.util.HashSet;
import java.util.Scanner;

public class SubsetOrNot {
    public static boolean subsetChecker(HashSet<Integer> subset,HashSet<Integer> set){
        for(int el:subset){
            if(!set.contains(el)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> subset=new HashSet<>();
        System.out.print("Enter number of elements in subset:");
        int n1=sc.nextInt();
        System.out.print("Enter elements of subset:");
        for(int i=0;i<n1;i++){
            subset.add(sc.nextInt());
        }
        System.out.print("Enter number of elements in set:");
        int n2=sc.nextInt();
        HashSet<Integer> set=new HashSet<>();
        System.out.print("Enter elements of set:");
        for(int i=0;i<n2;i++){
            set.add(sc.nextInt());
        }
        boolean subsetOrNot=subsetChecker(subset,set);
        if(subsetOrNot){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
