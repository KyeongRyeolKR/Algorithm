import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(String s) {
        List<String> strings = Arrays.stream(s.split(" "))
            .collect(Collectors.toList());

        for(int i=0; i<strings.size(); i++) {
            if(strings.get(i).equals("Z")) {
                strings.remove(i-1);
            }
        }

        return strings.stream()
                .filter(e -> !e.equals("Z"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}