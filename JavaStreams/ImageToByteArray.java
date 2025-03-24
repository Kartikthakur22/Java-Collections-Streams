package JavaStreams;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";  // Replace with actual image file path
        String destinationImage = "copy.jpg";

        byte[] imageBytes = convertImageToByteArray(sourceImage);
        if (imageBytes != null) {
            writeByteArrayToImage(imageBytes, destinationImage);
            System.out.println("Image successfully copied.");
        } else {
            System.err.println("Failed to convert image.");
        }
    }

    public static byte[] convertImageToByteArray(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            System.err.println("Error converting image to byte array: " + e.getMessage());
            return null;
        }
    }

    public static void writeByteArrayToImage(byte[] imageBytes, String filePath) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.err.println("Error writing byte array to image: " + e.getMessage());
        }
    }
}
