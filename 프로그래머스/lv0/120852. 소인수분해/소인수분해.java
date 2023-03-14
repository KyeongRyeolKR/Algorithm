import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(n % i == 0) {
                if(isSo(i)) list.add(i);
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    public static boolean isSo(int n) {
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(n % i == 0) cnt++;
        }
        return cnt == 2;
    }
}