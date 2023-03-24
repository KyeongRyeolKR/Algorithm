import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while(list.size() != n) {
            if(i % 3 != 0 && !String.valueOf(i).contains("3")) {
                list.add(i);
            }
            i++;
        }

        return list.get(n-1);
    }
}