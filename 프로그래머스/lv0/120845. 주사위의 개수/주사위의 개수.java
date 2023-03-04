import java.util.Arrays;

class Solution {
    public int solution(int[] box, int n) {
        return Arrays.stream(box)
                .map(e -> e / n)
                .reduce(1, (x, y) -> x * y);
    }
}