import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter a string: ");
        String inputString = scanner.nextLine();
        String palindrome = Palindrome(inputString);
        System.out.println(inputString + "-" + palindrome);
    }

    public static String Palindrome(String str) {
        if (str.length() <= 1) {
            return str;

        } else {
            return str.charAt(str.length() - 1)  +Palindrome(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
        }
    }
}
