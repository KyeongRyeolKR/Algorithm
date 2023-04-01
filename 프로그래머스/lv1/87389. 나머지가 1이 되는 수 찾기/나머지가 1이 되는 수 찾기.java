import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.iterate(1, e -> e + 1)
                .filter(e -> n % e == 1)
                .findFirst()
                .orElse(0);
    }
}