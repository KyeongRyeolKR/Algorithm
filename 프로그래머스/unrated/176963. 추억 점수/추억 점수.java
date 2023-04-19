import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> info = new HashMap<>();

        for(int i=0; i<name.length; i++) {
            info.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                if(info.get(photo[i][j]) != null) {
                    sum += info.get(photo[i][j]);
                }
            }
            result[i] = sum;
        }
        
        return result;
    }
}