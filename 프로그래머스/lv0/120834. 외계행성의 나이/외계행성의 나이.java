import java.util.stream.Collectors;

class Solution {
    public String solution(int age) {
        return String.valueOf(age).chars()
                .mapToObj(e -> String.valueOf((char) (e + 49)))
                .collect(Collectors.joining());
    }
}