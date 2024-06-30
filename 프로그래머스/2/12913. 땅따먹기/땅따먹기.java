class Solution {
    static int dp[][];
    
    int solution(int[][] land) {
        int answer = 0;

        dp = new int[land.length][land[0].length];

        for (int j = 0; j < land[0].length; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][1] = land[i][1] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][2] = land[i][2] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][3]);
            dp[i][3] = land[i][3] + Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }

        for (int j = 0; j < land[0].length; j++) {
            answer = Math.max(answer, dp[land.length - 1][j]);
        }

        return answer;
    }
}