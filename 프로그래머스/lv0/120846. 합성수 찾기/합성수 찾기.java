class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(isHap(i)) answer++;
        }
        return answer;
    }

    private boolean isHap(int n) {
        int result = 0;
        for(int i=1; i<=n; i++) {
            if (n % i == 0) {
                result++;
            }
        }
        return result > 2;
    }
}