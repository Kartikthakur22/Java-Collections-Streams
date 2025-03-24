package Collections.ListInterface;

import java.util.*;

public class RemoveNodeFromLast {
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        for (int i = 0; i < N; i++) {
            if (!first.hasNext()) {
                return null;
            }
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements of the linked list separated by space:");
        String[] input = scanner.nextLine().split(" ");

        LinkedList<String> list = new LinkedList<>(Arrays.asList(input));

        System.out.println("Enter the value of N:");
        int N = scanner.nextInt();

        String result = findNthFromEnd(list, N);

        if (result == null) {
            System.out.println("The list does not have " + N + " elements.");
        } else {
            System.out.println("The " + N + "th element from the end is: " + result);
        }
    }
}
