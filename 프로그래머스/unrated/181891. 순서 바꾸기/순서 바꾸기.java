import java.util.ArrayList;
import java.util.List;

/**
 * [2, 1, 6]	    1	[1, 6, 2]
 * [5, 2, 1, 7, 5]	3	[7, 5, 5, 2, 1]
 */
class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=n; i<num_list.length; i++) {
            list.add(num_list[i]);
        }
        for(int i=0; i<n; i++) {
            list.add(num_list[i]);
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}