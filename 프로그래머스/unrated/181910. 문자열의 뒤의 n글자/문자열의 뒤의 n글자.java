import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String my_string, int n) {
        return IntStream.rangeClosed(my_string.length() - n, my_string.length()-1)
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining());
    }
}