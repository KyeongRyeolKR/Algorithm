import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.split("");
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[arr.length];

        for(int i=0; i<arr.length; i++) {
            if(map.get(arr[i]) == null) {
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(arr[i]);
            }
            map.put(arr[i], i);
        }
        
        return answer;
    }
}