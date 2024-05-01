import java.util.Scanner;

public class Main {

    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        cost = new int[n][3];
        dp = new int[n][3];

        for(int i=0; i<n; i++) {
            cost[i][red] = sc.nextInt();
            cost[i][green] = sc.nextInt();
            cost[i][blue] = sc.nextInt();
        }

        dp[0][red] = cost[0][red];
        dp[0][green] = cost[0][green];
        dp[0][blue] = cost[0][blue];

        System.out.print(Math.min(paintCost(n- 1, red), Math.min(paintCost(n - 1, green), paintCost(n - 1, blue))));
    }

    static int paintCost(int n, int color) {
        if(dp[n][color] == 0) {
            if(color == red) {
                dp[n][red] = Math.min(paintCost(n - 1, green), paintCost(n - 1, blue)) + cost[n][red];
            } else if(color == green) {
                dp[n][green] = Math.min(paintCost(n - 1, red), paintCost(n - 1, blue)) + cost[n][green];
            } else {
                dp[n][blue] = Math.min(paintCost(n - 1, red), paintCost(n - 1, green)) + cost[n][blue];
            }
        }

        return dp[n][color];
    }
}