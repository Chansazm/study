import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("Enter a number, operator or ? for help: ");
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                stack.push(number);
            } catch (NumberFormatException e) {
                switch (input) {
                    case "+":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int addResult = stack.pop() + stack.pop();
                        stack.push(addResult);
                        break;
                    case "*":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int multiplyResult = stack.pop() * stack.pop();
                        stack.push(multiplyResult);
                        break;
                    case "-":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int subtractResult = stack.pop();
                        subtractResult = stack.pop() - subtractResult;
                        stack.push(subtractResult);
                        break;
                    case "/":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int divisor = stack.pop();
                        int dividend = stack.pop();
                        int divideResult = dividend / divisor;
                        stack.push(divideResult);
                        break;
                    case "%":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int modDivisor = stack.pop();
                        int modDividend = stack.pop();
                        int modResult = modDividend % modDivisor;
                        stack.push(modResult);
                        break;
                    case "m":
                        if (stack.empty()) {
                            System.out.println("Stack is empty");
                            break;
                        }
                        int negated = stack.pop();
                        negated = -negated;
                        stack.push(negated);
                        break;
                    case "r":
                        if (stack.size() < 2) {
                            System.out.println("Not enough operands on stack");
                            break;
                        }
                        int top = stack.pop();
                        int second = stack.pop();
                        stack.push(top);
                        stack.push(second);
                        break;
                    case "d":
                        if (stack.empty()) {
                            System.out.println("Stack is empty");
                            break;
                        }
                        int duplicated = stack.peek();
                        stack.push(duplicated);
                        break;
                    case "p":
                        if (stack.empty()) {
                            System.out.println("Stack is empty");
                            break;
                        }
                        System.out.println(stack.peek());
                        break;
                    case "n":
                        if (stack.empty()) {
                            System.out.println("Stack is empty");
                            break;
                        }
                        System.out.println(stack.pop());
                        break;
                    case "f":
                        if (stack.empty()) {
                            System.out.println("Stack is empty");
                            break;
                        }
                        for (int i = stack.size() - 1; i >= 0; i--) {
                            System.out.println(stack.get(i));
                        }
                        break;
                    case "c":
                        stack.clear();
                        break;
                    case "q":
                        isRunning = false;
                        break;
                    case "?":
                    case "h":
                        System.out.println("Enter a number to push to stack\n");
                        break;
                }
            }
        }
    }
}