import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).map(e -> e * e).sum() : IntStream.rangeClosed(1, n).filter(i -> i % 2 == 1).sum();
    }
}