package Collections.ListInterface;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements in arraylist:");
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.print("Enter elements of arraylist:");
        for(int i=0;i<n;i++){
            int element=sc.nextInt();
            list.add(element);
        }
        list=removeDuplicates(list);
        System.out.print("After removing duplicates:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        } 
    }
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list){
        Set<Integer> linkedHs=new LinkedHashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int el:list){
            linkedHs.add(el);
        }
        for(int el:linkedHs){
            ans.add(el);
        }
        return ans;
    }
}
