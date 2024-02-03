import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = Arrays.stream(phone_book)
                .collect(Collectors.toSet());

        for(String num : set) {
            for(int i=1; i<num.length(); i++) {
                if(set.contains(num.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}