package JavaStreams;

import java.io.*;

public class FileCopyComparison {
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Replace with actual file path
        String destFileBuffered = "dest_buffered.txt";
        String destFileUnbuffered = "dest_unbuffered.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyFileBuffered(sourceFile, destFileBuffered);
        System.out.println("Buffered Stream Time: " + bufferedTime + " nanoseconds");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyFileUnbuffered(sourceFile, destFileUnbuffered);
        System.out.println("Unbuffered Stream Time: " + unbufferedTime + " nanoseconds");
    }

    public static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }

    public static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return System.nanoTime() - startTime;
    }
}

