package Collections.ListInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter total number of fruits:");
        int n=sc.nextInt();
        ArrayList<String> list=new ArrayList<>();
        System.out.print("Enter fruits:");
        for(int i=0;i<n;i++){
            list.add(i,sc.next());
        }
        HashMap<String,Integer> ans=frequencyCalculation(list);
        for(String str:ans.keySet()){
            System.out.print(str+":"+ans.get(str)+" ");
        }
    }
    public static HashMap<String,Integer> frequencyCalculation(ArrayList<String> list){
        HashMap<String,Integer> hm=new HashMap<>();
        for(String str:list){
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        return hm;
    }
}
