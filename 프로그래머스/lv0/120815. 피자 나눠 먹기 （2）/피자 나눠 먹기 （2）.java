class Solution {
    public int solution(int n) {
        return getLCM(6, n) / 6;
    }

    private int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    private int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }
}