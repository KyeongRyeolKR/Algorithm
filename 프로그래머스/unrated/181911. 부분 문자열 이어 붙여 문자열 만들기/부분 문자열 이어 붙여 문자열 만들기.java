import java.util.stream.IntStream;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();

        IntStream.range(0, my_strings.length)
                .forEach(i -> answer.append(my_strings[i], parts[i][0], parts[i][1] + 1));

        return answer.toString();
    }
}
