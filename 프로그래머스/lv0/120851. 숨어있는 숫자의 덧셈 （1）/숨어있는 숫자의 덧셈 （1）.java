import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split(""))
                .filter(e -> Character.isDigit(e.charAt(0)))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}