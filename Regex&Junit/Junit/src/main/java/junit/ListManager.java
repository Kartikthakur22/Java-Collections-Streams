package junit;

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    List<Integer> list=new ArrayList<>();
    public void addElement(List<Integer> list, int element){
        list.add(element);
    }
    public void removeElement(List<Integer> list, int element){
        list.remove(Integer.valueOf(element));
    }
    public int getSize(List<Integer> list){
        return list.size();
    }
}
