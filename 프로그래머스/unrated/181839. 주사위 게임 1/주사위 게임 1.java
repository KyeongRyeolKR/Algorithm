class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if(isOdd(a) && isOdd(b)) {
            answer = (a * a) + (b * b);
        } else if(isOdd(a) || isOdd(b)) {
            answer = 2 * (a + b);
        } else {
            answer = Math.abs(a - b);
        }

        return answer;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}