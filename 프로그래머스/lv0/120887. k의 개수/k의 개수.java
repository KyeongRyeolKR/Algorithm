import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int i, int j, int k) {
        String str = IntStream.rangeClosed(i,j)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return (int) Arrays.stream(str.split(""))
                .filter(e -> String.valueOf(k).equals(String.valueOf(e)))
                .count();
    }
}