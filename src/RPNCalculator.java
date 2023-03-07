import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        printHelp();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            } else if (input.equals("h") || input.equals("?")) {
                printHelp();
            } else if (input.equals("f")) {
                System.out.println(stack);
            } else if (input.equals("c")) {
                stack.clear();
            } else if (input.equals("d")) {
                if (!stack.isEmpty()) {
                    stack.push(stack.peek());
                } else {
                    System.out.println("Stack is empty.");
                }
            } else if (input.equals("p")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("Stack is empty.");
                }
            } else if (input.equals("n")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println("Stack is empty.");
                }
            } else if (input.equals("r")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(first);
                    stack.push(second);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("+")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second + first);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("*")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second * first);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("-")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("/")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("%")) {
                if (stack.size() >= 2) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second % first);
                } else {
                    System.out.println("Stack does not have enough elements.");
                }
            } else if (input.equals("m")) {
                if (!stack.isEmpty()) {
                    int value = stack.pop();
                    stack.push(-value);
                } else {
                    System.out.println("Stack is empty.");
                }
            } else {
                try {
                    int value = Integer.parseInt(input);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }
        }
        System.out.println("Exiting RPN Calculator.");
    }

    private static void printHelp() {
        System.out.println("Available operations:");
        System.out.println("+ : add the top two items");
        System.out.println("* : multiply the top two items");
        System.out.println("- : subtract the top item from the next item");
        System.out.println("/ : integer divide the second item by the top item");
        System.out.println("% : find the integer remainder when dividing the second item by the top item");
        System.out.println("m : unary minus -- negate the top item");
        System.out.println("r : exchange the top two items");
        System.out.println("d : duplicate top item on stack");
        System.out.println("p : print (to the screen) the top item");
        System.out.println("n : print and remove the top item");
        System.out.println("f : print all the contents of the stack (leaving it intact)");
        System.out.println("c : clear the stack");
        System.out.println("q : quit");
        System.out.println("h or ? : print this help message");
    }
}