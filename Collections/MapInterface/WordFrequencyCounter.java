package Collections.MapInterface;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();
        scanner.close();
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        Map<String, Integer> wordCount = new HashMap<>();
        String line;
        
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        
        System.out.println(wordCount);
    }
}
