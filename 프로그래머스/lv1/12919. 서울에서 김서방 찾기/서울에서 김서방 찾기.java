import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] seoul) {
        int index = Arrays.stream(seoul)
                .collect(Collectors.toList())
                .indexOf("Kim");

        return String.format("김서방은 %d에 있다", index);
    }
}