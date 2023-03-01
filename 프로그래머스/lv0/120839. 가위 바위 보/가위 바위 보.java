import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        return Arrays.stream(rsp.split(""))
                .map(e -> e.equals("2") ? "0" : e.equals("0") ? "5" : "2")
                .collect(Collectors.joining());
    }
}