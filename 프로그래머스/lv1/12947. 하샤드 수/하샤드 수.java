import java.util.Arrays;

class Solution {
    public boolean solution(int x) {
        int sum = Arrays.stream(String.valueOf(x).split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        return x % sum == 0;
    }
}