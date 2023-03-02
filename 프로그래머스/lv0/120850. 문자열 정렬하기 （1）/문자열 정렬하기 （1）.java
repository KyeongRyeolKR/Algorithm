import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[^0-9]", "").split(""))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}