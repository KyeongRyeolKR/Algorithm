import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int a = IntStream.rangeClosed(left, right)
                .filter(e -> yaksuCount(e) % 2 == 0)
                .sum();

        int b = IntStream.rangeClosed(left, right)
                .filter(e -> yaksuCount(e) % 2 != 0)
                .sum();

        return a - b;
    }

    private int yaksuCount(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .count();
    }
}