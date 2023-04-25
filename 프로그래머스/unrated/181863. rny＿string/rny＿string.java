import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String rny_string) {
        return Arrays.stream(rny_string.split(""))
                .map(e -> e.equals("m") ? "rn" : e)
                .collect(Collectors.joining());
    }
}