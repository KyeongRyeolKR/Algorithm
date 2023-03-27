class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];

        int commonDenom = denom1 * denom2;
        int numer1_ = numer1 * denom2;
        int numer2_ = numer2 * denom1;

        int gcd = getGCD(commonDenom, numer1_ + numer2_);

        answer[0] = (numer1_ + numer2_) / gcd;
        answer[1] = commonDenom / gcd;

        return answer;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}