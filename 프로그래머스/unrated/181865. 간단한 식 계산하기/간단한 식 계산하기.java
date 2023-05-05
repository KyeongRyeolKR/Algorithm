
import java.util.Arrays;

class Solution {
    public int solution(String binomial) {
        String[] numbers;
        if(binomial.contains(" + ")) {
            numbers = binomial.split(" \\+ ");
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } else if(binomial.contains(" - ")) {
            numbers = binomial.split(" \\- ");
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .reduce((e1, e2) -> e1 - e2)
                    .getAsInt();
        } else {
            numbers = binomial.split(" \\* ");
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .reduce((e1, e2) -> e1 * e2)
                    .getAsInt();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("43 + 12"));
    }
}