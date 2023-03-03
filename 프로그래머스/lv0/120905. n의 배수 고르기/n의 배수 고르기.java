import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(e -> e % n == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}