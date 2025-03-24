package Collections.SetInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SortList {
    public static void sorting(ArrayList<Integer> list){
        int n=list.size();
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(list.get(j)>list.get(j+1)){
                    int t=list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,t);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set=new HashSet<>();
        System.out.print("Enter number of elements in set:");
        int n=sc.nextInt();
        System.out.print("Enter elements of set:");
        for(int i=0;i<n;i++){
            set.add(sc.nextInt());
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        sorting(list);
        System.out.print("After sorting the set:");
        System.out.println(list);
    }
}
