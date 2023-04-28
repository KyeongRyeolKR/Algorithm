import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int multi = Arrays.stream(num_list)
                .reduce(1, (e1, e2) -> e1 * e2);

        int sum = Arrays.stream(num_list)
                .sum();

        return multi < sum * sum ? 1 : 0;
    }
}