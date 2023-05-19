import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();

        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                list.add(arr[i]);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}