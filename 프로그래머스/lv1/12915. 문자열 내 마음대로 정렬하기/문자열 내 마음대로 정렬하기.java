import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted(Comparator.comparing((String e) -> e.charAt(n))
                        .thenComparing(Comparator.naturalOrder()))
                .toArray(String[]::new);
    }
}