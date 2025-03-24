package Collections.MapInterface;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> originalMap = new HashMap<>();
        
        System.out.print("Enter number of entries: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        while (n-- > 0) {
            System.out.print("Enter key and value (space-separated): ");
            String[] input = scanner.nextLine().split(" ");
            originalMap.put(input[0], Integer.parseInt(input[1]));
        }
        scanner.close();
        
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        originalMap.forEach((key, value) -> invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key));
        
        System.out.println(invertedMap);
    }
}
