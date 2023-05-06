import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        for(int i=0; i<delete_list.length; i++) {
            list.remove(Integer.valueOf(delete_list[i]));
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}