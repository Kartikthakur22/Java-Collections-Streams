package Collections.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int top = queue1.peek();
        queue2.offer(queue1.poll());
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of operations you want to perform:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter operation (push <value>, pop, top):");
            String operation = scanner.next();
            
            if (operation.equals("push")) {
                int value = scanner.nextInt();
                stack.push(value);
                System.out.println("Pushed: " + value);
            } else if (operation.equals("pop")) {
                if (!stack.empty()) {
                    System.out.println("Popped: " + stack.pop());
                } else {
                    System.out.println("Stack is empty");
                }
            } else if (operation.equals("top")) {
                if (!stack.empty()) {
                    System.out.println("Top: " + stack.top());
                } else {
                    System.out.println("Stack is empty");
                }
            } else {
                System.out.println("Invalid operation");
            }
        }
        scanner.close();
    }
}
