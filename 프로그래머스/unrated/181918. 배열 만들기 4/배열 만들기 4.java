import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        return stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}