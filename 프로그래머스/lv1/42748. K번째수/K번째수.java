import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<commands.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
                temp.add(array[j]);
            }

            Collections.sort(temp);

            answer.add(temp.get(commands[i][2]-1));
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}