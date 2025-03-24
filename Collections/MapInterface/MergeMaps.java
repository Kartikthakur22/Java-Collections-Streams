package Collections.MapInterface;

import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>(), mergedMap = new HashMap<>();
        
        System.out.print("Enter number of entries for Map1: ");
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            System.out.print("Enter key and value (space-separated): ");
            String[] input = scanner.nextLine().split(" ");
            map1.put(input[0], Integer.parseInt(input[1]));
        }
        
        System.out.print("Enter number of entries for Map2: ");
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            System.out.print("Enter key and value (space-separated): ");
            String[] input = scanner.nextLine().split(" ");
            map2.put(input[0], Integer.parseInt(input[1]));
        }
        scanner.close();
        
        mergedMap.putAll(map1);
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));
        
        System.out.println(mergedMap);
    }
}
