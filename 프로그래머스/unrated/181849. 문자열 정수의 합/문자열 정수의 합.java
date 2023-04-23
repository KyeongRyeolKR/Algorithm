import java.util.Arrays;

class Solution {
    public int solution(String num_str) {
        return num_str.chars()
                .map(e -> e - '0')
                .sum();
    }
}