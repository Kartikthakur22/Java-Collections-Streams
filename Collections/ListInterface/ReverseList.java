package Collections.ListInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class ReverseList{
    public static void reverseList(ArrayList<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
    public static void reverseLinkedList(LinkedList<Integer> list){
        int i=0;
        int j=list.size()-1;
        while(i<j){
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
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
        reverseList(list);
        System.out.print("After reversing arraylist:");
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print("Enter number of elements in linkedlist:");
        int n2=sc.nextInt();
        LinkedList<Integer> list2=new LinkedList<>();
        System.out.print("Enter elements of linkedlist:");
        for(int i=0;i<n2;i++){
            int element=sc.nextInt();
            list2.add(element);
        }
        reverseLinkedList(list2);
        System.out.print("After reversing linkedlist:");
        for(int i=0;i<n2;i++){
            System.out.print(list2.get(i)+" ");
        }
    }
}
