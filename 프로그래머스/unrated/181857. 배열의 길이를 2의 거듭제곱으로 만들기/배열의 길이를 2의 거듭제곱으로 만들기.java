import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int num = 0;
        for(int i=0; i<11; i++) {
            if (list.size() <= Math.pow(2, i)) {
                num = (int) Math.pow(2, i);
                break;
            }
        }

        while(list.size() != num) {
            list.add(0);
        }
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}