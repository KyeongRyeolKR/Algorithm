import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        return Arrays.stream(Arrays.stream((n + "").split(""))
                .reduce((a, b) -> b + a)
                .get()
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}