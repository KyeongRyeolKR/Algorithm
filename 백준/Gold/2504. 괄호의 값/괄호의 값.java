import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String n = br.readLine();
        Stack<Character> stack = new Stack<>();
        
        int result = 0;
        int value = 1;
        for(int i=0; i<n.length(); i++) {
            if(n.charAt(i) == '(') {
                stack.push(n.charAt(i));
                value *= 2;
            } else if(n.charAt(i) == '[') {
                stack.push(n.charAt(i));
                value *= 3;
            } else if(n.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(n.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(n.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (n.charAt(i - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        
        if(!stack.isEmpty()) {
            sb.append(0).append("\n");
        } else {
            sb.append(result).append("\n");
        }
        
        System.out.println(sb);
    }
}