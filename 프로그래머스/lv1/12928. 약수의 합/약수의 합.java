import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        IntStream.rangeClosed(1,n)
                .filter(e -> n % e == 0)
                .forEach(list::add);
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}