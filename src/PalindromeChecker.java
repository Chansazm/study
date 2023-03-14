import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

//Class Declaration
class PalindromeChecker {
    //method to check if string is a palindrome
    public static boolean isPalindrome(String inputString) {
        //input verification and validation
        inputString = inputString.toLowerCase().replaceAll("[^a-z0-9]", "");
        //Forming the stack and queue structures
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        //iterating through the input string
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            //pushing to the stack and adding to the stack
            stack.push(c);
            queue.add(c);
        }
        //Comparing the items from the queue and the stack
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }
        return true;
    }
}

//Class Instantiation
class DriverProgram {
    public static void main(String[] args) {
        String s1 = "Madam, I'm Adam";
        String s2 = "A Toyota";
        String s3 = "raceCar";
        String s4 = "University";
        System.out.println(PalindromeChecker.isPalindrome(s1)); // true
        System.out.println(PalindromeChecker.isPalindrome(s2)); // false
        System.out.println(PalindromeChecker.isPalindrome(s3)); // true
        System.out.println(PalindromeChecker.isPalindrome(s4)); // false
    }
}
