import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        list.remove(Collections.min(list));
        
        if(list.size() == 0) {
            return new int[]{-1};
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}