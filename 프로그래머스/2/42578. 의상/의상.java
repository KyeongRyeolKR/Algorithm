import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] type : clothes) {
            map.put(type[1], map.getOrDefault(type[1], 0) + 1);
        }

        int count = 1;
        for (int value : map.values()) {
            count *= value + 1;
        }

        return count - 1;
    }
}