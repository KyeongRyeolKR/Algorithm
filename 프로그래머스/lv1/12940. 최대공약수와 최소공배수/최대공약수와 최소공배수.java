class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }

    private int getGCD(int num1, int num2) {
        int result = 0;
        for(int i=1; i<=Math.min(num1, num2); i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                result = i;
            }
        }
        return result;
    }
}