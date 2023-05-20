import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++) {
            list.add(score[i]);
            list.sort(Collections.reverseOrder());
            if(list.size() <= k) {
                answer.add(list.get(list.size()-1));
                continue;
            }
            answer.add(list.get(k-1));
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}