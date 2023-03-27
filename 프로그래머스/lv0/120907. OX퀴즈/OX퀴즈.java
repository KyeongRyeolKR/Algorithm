import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] quiz) {
        return Arrays.stream(quiz)
                .map(this::check)
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }

    private String check(String str) {
        int answer = Integer.parseInt(str.split(" = ")[1]);
        String exp = str.split(" = ")[0];
        String op = str.split(" ")[1];

        int testAnswer = Integer.MIN_VALUE;
        if(op.equals("-")) {
            String[] numbers_ = exp.split(" - ");
            testAnswer = Integer.parseInt(numbers_[0]) - Integer.parseInt(numbers_[1]);
        }
        if(op.equals("+")) {
            String[] numbers_ = exp.split(" \\+ ");
            testAnswer = Integer.parseInt(numbers_[0]) + Integer.parseInt(numbers_[1]);
        }

        if(answer == testAnswer) return "O";

        return "X";
    }
}