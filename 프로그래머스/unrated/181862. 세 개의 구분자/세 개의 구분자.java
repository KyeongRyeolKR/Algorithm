import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        String[] arr = Arrays.stream(myStr.split("[abc]"))
                .filter(e -> !e.isBlank())
                .toArray(String[]::new);

        if(arr.length == 0) {
            return new String[]{"EMPTY"};
        }

        return arr;
    }
}