import java.util.*;

public class PalindroneCheckerApp {

    // Method 1: Reverse String
    public static boolean reverseCheck(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }
        return input.equals(reversed);
    }

    // Method 2: Stack
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return input.equals(reversed);
    }

    // Method 3: Deque
    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        // Reverse method timing
        start = System.nanoTime();
        boolean result1 = reverseCheck(input);
        end = System.nanoTime();
        long reverseTime = end - start;

        // Stack method timing
        start = System.nanoTime();
        boolean result2 = stackCheck(input);
        end = System.nanoTime();
        long stackTime = end - start;

        // Deque method timing
        start = System.nanoTime();
        boolean result3 = dequeCheck(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        System.out.println("\nResults:");
        System.out.println("Reverse Method: " + result1 + " | Time: " + reverseTime + " ns");
        System.out.println("Stack Method: " + result2 + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method: " + result3 + " | Time: " + dequeTime + " ns");

        sc.close();
    }
}
