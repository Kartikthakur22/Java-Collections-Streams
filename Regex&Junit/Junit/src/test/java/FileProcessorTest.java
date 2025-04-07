import junit.FileProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileProcessorTest {
    private FileProcessor fileProcessor;
    private final String testFilename = "testfile.txt";

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, World!";
        fileProcessor.writeToFile(testFilename, content);

        String readContent = fileProcessor.readFromFile(testFilename);
        assertEquals(content, readContent, "Content should match what was written");
    }


    @Test
    void testReadFromNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistent.txt");
        }, "Should throw IOException if file doesn't exist");
    }
}
