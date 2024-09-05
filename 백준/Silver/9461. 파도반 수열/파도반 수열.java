import java.util.Scanner;

public class Main {

    static Long[] dp = new Long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            System.out.println(sequence(n));
        }

    }

    public static long sequence(int N) {
        if(dp[N] == null) {
            dp[N] = sequence(N - 2) + sequence(N - 3);
        }

        return dp[N];
    }

}