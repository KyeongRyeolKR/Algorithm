import java.util.*;
import java.util.stream.Collectors;

/**
 * 6	[1, 3, 2, 5, 4, 5, 2, 3]	3
 * 4	[1, 3, 2, 5, 4, 5, 2, 3]	2
 * 2	[1, 1, 1, 1, 2, 2, 2, 3]	1
 */
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++) {
            if(!map.containsKey(tangerine[i])) {
                map.put(tangerine[i], 1);
            } else {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            }
        }

        List<Integer> values = map.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int count = 0;
        for(int i=0; i<values.size(); i++) {
            k -= values.get(i);
            count++;
            if(k < 1) {
                return count;
            }
        }
        
        return count;
    }
}