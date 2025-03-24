package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter the number of elements in the queue: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the queue:");
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);

        scanner.close();
    }
}
