import java.util.*;
import java.util.stream.Collectors;

/**
 * 최대	개수		점수                                     결과
 * 3	4	    [1, 2, 3, 1, 2, 3, 1]	                8
 * 4	3	    [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]	33
 */
class Solution {
    public int solution(int k, int m, int[] score) {
        List<Integer> list = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int result = 0;
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            temp.add(list.get(i));
            
            if((i+1) % m == 0) {
                int min = Collections.min(temp);
                
                result += min * m;
                
                temp = new ArrayList<>();
            }
        }

        return result;
    }
}