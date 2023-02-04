import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int number = sc.nextInt();
            if (number == 0) break;
            String number_ = String.valueOf(number);

            String reverseNumber_ = reverseString(number_);

            System.out.println(isPalindrome(number_, reverseNumber_));
        }
    }

    private static String reverseString(String target) {
        StringBuilder builder = new StringBuilder(target);
        return builder.reverse().toString();
    }

    private static String isPalindrome(String target1, String target2) {
        return target1.equals(target2) ? "yes" : "no";
    }
}
