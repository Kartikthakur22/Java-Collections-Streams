package JavaStreams;

import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Replace with actual file path
        String destinationFile = "output.txt";

        convertUppercaseToLowercase(sourceFile, destinationFile);
    }

    public static void convertUppercaseToLowercase(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File successfully converted to lowercase and saved as " + destination);
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}

