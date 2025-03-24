package Collections.MapInterface;

import java.util.*;

public class MaxValueKeyFinder {

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (String key : map.keySet()) {
            if (map.get(key) > maxValue) {
                maxValue = map.get(key);
                maxKey = key;
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.println("Enter the number of entries:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter key (String):");
            String key = scanner.nextLine();

            System.out.println("Enter value (Integer):");
            int value = scanner.nextInt();
            scanner.nextLine();

            map.put(key, value);
        }

        String keyWithMaxValue = findKeyWithMaxValue(map);
        System.out.println("Key with the highest value: " + keyWithMaxValue);

        scanner.close();
    }
}

