import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            System.out.println(isVps(sc.next()));
        }
    }

    private static String isVps(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(c);
            } else if(stack.isEmpty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}