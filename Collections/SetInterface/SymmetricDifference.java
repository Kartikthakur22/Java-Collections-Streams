package Collections.SetInterface;

import java.util.HashSet;
import java.util.Scanner;

public class SymmetricDifference{
    public static HashSet<Integer> symmetricDifferenceFinder(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> ans=new HashSet<>();
        for(int el:set1){
            if(!set2.contains(el)){
                ans.add(el);
            }
        }
        for(int el:set2){
            if(!set1.contains(el)){
                ans.add(el);
            }
        }
        return ans;
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
        HashSet<Integer> ans=symmetricDifferenceFinder(set1, set2);
        System.out.print("{ ");
        for(int el:ans){
            System.out.print(el+" ");
        }
        System.out.print("}");
    }
}