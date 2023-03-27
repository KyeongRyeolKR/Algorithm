class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++) {
            answer[i] = check(quiz[i]);
        }

        return answer;
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