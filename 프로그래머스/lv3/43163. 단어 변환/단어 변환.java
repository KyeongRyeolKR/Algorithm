import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    static List<Integer> answer;
    static List<String> visited;
    static int count;

    public int solution(String begin, String target, String[] words) {
        boolean isExist = Arrays.asList(words).contains(target);

        if(!isExist) return 0;

        answer = new ArrayList<>();
        visited = new ArrayList<>();

        dfs(begin, target, words);

        return Collections.min(answer);
    }

    private void dfs(String now, String target, String[] words) {
        visited.add(now);

        if(diffCount(now, target) == 1) {
            answer.add(++count);
        }

        for(int i=0; i<words.length; i++) {
            if(!visited.contains(words[i]) && diffCount(now, words[i]) == 1) {
                count++;
                dfs(words[i], target, words);
            }
        }
    }

    private int diffCount(String origin, String target) {
        String[] t = target.split("");

        for (String s : t) {
            origin = origin.replaceFirst(s, "");
        }

        return origin.length();
    }

    // public static void main(String[] args) {
    //     System.out.println(
    //             new Solution().solution(
    //                     "hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
    //             )
    //     );
    // }
}