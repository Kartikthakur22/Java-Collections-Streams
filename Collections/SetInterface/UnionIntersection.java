package Collections.SetInterface;

import java.util.HashSet;
import java.util.Scanner;

public class UnionIntersection {
    public static HashSet<Integer> unionFind(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> union=new HashSet<>();
        for(int el:set1){
            union.add(el);
        }
        for(int el:set2){
            union.add(el);
        }
        return union;
    }
    public static HashSet<Integer> intersectionFind(HashSet<Integer> set1,HashSet<Integer> set2){
        HashSet<Integer> intersection=new HashSet<>();
        for(int el:set1){
            if(set2.contains(el)){
                intersection.add(el);
            }
        }
        return intersection;
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
        HashSet<Integer> union=unionFind(set1, set2);
        HashSet<Integer> intersection=intersectionFind(set1, set2);
        System.out.print("Union:{ ");
        for(int el:union){
            System.out.print(el+" ");
        }
        System.out.print("} Intersection:{ ");
        for(int el:intersection){
            System.out.print(el+" ");
        }
        System.out.print("}");
    }
}
