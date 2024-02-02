import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<number.length(); i++) {
            char now = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < now && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(now);
        }

        return stack.stream()
                .limit(number.length()-k)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}