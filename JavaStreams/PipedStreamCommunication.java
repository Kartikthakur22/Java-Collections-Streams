package JavaStreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);
            
            writer.start();
            reader.start();
        } catch (IOException e) {
            System.err.println("Error setting up piped streams: " + e.getMessage());
        }
    }
}

