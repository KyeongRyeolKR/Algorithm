import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<array.length; i++) {
            int count = 1;
            for(int j=0; j<array.length; j++) {
                if(i == j) continue;
                if(array[i] == array[j]) count++;
            }
            map.put(array[i], count);
        }
        
        int max = 0;
        int name = 0;
        for (int x : map.keySet()) {
            if(map.get(x) > max) {
                max = map.get(x);
                name = x;
            }
        }

        int count = 0;
        for(int x : map.keySet()) {
            if(map.get(x) == max) count++;
        }

        if(count > 1) return -1;

        return name;
    }
}