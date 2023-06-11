import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] strArr) {
        return Arrays.stream(Arrays.stream(strArr)
                .mapToInt(String::length)
                .toArray())
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values()
                .stream()
                .map(Long::intValue)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }
}