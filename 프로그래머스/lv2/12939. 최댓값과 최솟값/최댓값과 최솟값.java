import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        return min + " " + max;
    }
}