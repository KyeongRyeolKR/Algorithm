import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

class Solution {
    public int solution(String before, String after) {
        String str = before.concat(after);

        Set<String> set = new HashSet<>(Arrays.asList(before.split("")));
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            int cnt = 0;
            String x = iterator.next();

            for(int i=0; i<str.length(); i++) {
                if(String.valueOf(str.charAt(i)).equals(x)) cnt++;
            }

            if(cnt % 2 != 0) return 0;
        }
        return 1;
    }
}