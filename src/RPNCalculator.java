import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("+") || input.equals("*") || input.equals("-") || input.equals("/") || input.equals("%")) {
                if (stack.size() < 2) {
                    System.out.println("Not enough operands on stack");
                } else {
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (input) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "/":
                            stack.push(a / b);
                            break;
                        case "%":
                            stack.push(a % b);
                            break;
                    }
                }
            } else if (input.equals("m")) {
                if (stack.empty()) {
                    System.out.println("Stack is empty");
                } else {
                    int a = stack.pop();
                    stack.push(-a);
                }
            } else if (input.equals("r")) {
                if (stack.size() < 2) {
                    System.out.println("Not enough operands on stack");
                } else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(b);
                    stack.push(a);
                }
            } else if (input.equals("d")) {
                if (stack.empty()) {
                    System.out.println("Stack is empty");
                } else {
                    int a = stack.peek();
                    stack.push(a);
                }
            } else if (input.equals("p")) {
                if (stack.empty()) {
                    System.out.println("Stack is empty");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (input.equals("n")) {
                if (stack.empty()) {
                    System.out.println("Stack is empty");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (input.equals("f")) {
                if (stack.empty()) {
                    System.out.println("Stack is empty");
                } else {
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        System.out.println(stack.get(i));
                    }
                }
            } else if (input.equals("c")) {
                stack.clear();
            } else if (input.equals("q")) {
                break;
            } else if (input.equals("?") || input.equals("h")) {
                System.out.println("Enter a number to push to stack");
                System.out.println("+ to add the top two numbers");
                System.out.println("* to multiply the top two numbers");
                System.out.println("- to subtract the top item from the next item");
                System.out.println("/ to divide the second item by the top item");
                System.out.println("% to find the integer remainder when dividing the second item by the top item");
                System.out.println("m unary minus to negate the top item");
                System.out.println("r exchange the top two items");
                System.out.println("d to duplicate top two items");
                System.out.println("p to print to the screen the top item");
                System.out.println("n print and remove the top item");
                System.out.println("f print all the contents of the stack and leave it intact");
                System.out.println("c clear the stack");
                System.out.println("q to quit");
                System.out.println("h or ? for help");
            }
        }
    }
}
