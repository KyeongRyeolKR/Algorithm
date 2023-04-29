import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>(Arrays.stream(num_list).boxed().collect(Collectors.toList()));
        if (list.get(list.size() - 1) > list.get(list.size() - 2)) {
            list.add(list.get(list.size() - 1) - list.get(list.size() - 2));
        } else {
            list.add(2 * list.get(list.size() - 1));
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}