import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array) {
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        int maxValue = list.stream()
                .max(Integer::compareTo)
                .orElse(0);

        int maxIndex = list.indexOf(maxValue);

        return new int[]{maxValue, maxIndex};
    }
}