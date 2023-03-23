public class Solution {
    public static long solution(int balls, int share) {
        long answer = 1L;
        int cnt = 1;

        for (int i = share + 1; i <= balls; i++){
            answer *= i;
            answer /= cnt++;
        }

        return answer;
    }
}