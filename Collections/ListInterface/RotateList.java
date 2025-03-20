package Collections.ListInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateList {
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
        System.out.print("Enter position by which list to rotate:");
        int k=sc.nextInt();
        rotateList(list,k);
        System.out.print("After reversing arraylist:");
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static void rotateList(ArrayList<Integer> list,int k){
        reverse(list,0,list.size()-1);
        reverse(list,0,k-1);
        reverse(list,k,list.size()-1);
    }
    public static void reverse(ArrayList<Integer> list,int start,int end){
        int i=start;
        int j=end;
        while (i<j) {
            int t=list.get(i);
            list.set(i,list.get(j));
            list.set(j,t);
            i++;
            j--;
        }
    }
}
