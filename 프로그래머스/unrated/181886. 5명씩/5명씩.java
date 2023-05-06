import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
        
        IntStream.range(0, names.length)
                .filter(i -> i % 5 == 0)
                .forEach(i -> list.add(names[i]));
        
        return list.toArray(String[]::new);
    }
}