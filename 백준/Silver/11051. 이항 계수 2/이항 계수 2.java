import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    public static final int div = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        System.out.println(BC(n, k));
    }

    public static int BC(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k)) % div;
    }
}