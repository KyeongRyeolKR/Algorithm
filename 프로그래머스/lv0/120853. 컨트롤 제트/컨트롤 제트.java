import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();

        for(String x : s.split(" ")) {
            if(x.equals("Z")) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        return stack.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}