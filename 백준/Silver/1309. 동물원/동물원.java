import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int mod = 9901;
		int n = Integer.parseInt(br.readLine());
        
		long[][] dp = new long[n+1][3];
		dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

		for (int i=2; i<=n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}

		long answer = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
		bw.write(answer + "\n");
        
		bw.flush();
		bw.close();
		br.close();
	}

}