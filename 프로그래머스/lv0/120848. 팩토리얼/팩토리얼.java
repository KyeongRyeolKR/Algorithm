class Solution {
    public int solution(int n) {
        for(int i=10; i>=1; i--) {
            if(getFactorial(i) <= n) return i;
        }
        return -1;
    }

    public static int getFactorial(int n) {
        int result = 1;
        for(int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}