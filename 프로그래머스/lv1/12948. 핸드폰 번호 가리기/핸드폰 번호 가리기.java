import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String phone_number) {
        return Arrays.stream(phone_number.split(""))
                .limit(phone_number.length() - 4)
                .map(e -> "*")
                .collect(Collectors.joining()) + phone_number.substring(phone_number.length() - 4);
    }
}