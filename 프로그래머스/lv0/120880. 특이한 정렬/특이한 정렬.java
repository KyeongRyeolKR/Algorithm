import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numList, int n) {

        return Arrays.stream(numList)
                .boxed()
                .sorted(Comparator.comparingInt((Integer num) -> Math.abs(num - n))
                        .thenComparing(Comparator.reverseOrder()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}