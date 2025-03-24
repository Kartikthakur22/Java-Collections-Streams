package Collections.QueueInterface;

public class CircularBuffer {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(int value) {
        if (size < capacity) {
            buffer[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
        } else {
            buffer[tail] = value;  // Overwrite the oldest element
            tail = (tail + 1) % capacity;
            head = (head + 1) % capacity;  // Move head to next position
        }
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + (i == size - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();  // Buffer: [1, 2, 3]
        buffer.insert(4);
        buffer.display();  // Buffer: [2, 3, 4]
    }
}
