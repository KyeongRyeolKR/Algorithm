import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr)
                .map(e -> (e >= 50 && e % 2 == 0) ? e / 2 : (e < 50 && e % 2 != 0) ? e * 2 : e)
                .toArray();
    }
}