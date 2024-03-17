import java.util.Scanner;

/**
 * 수열 추측하기
 *      3 1 2 4
 *       4 3 6
 *        7 9
 *         16
 * N = 맨 윗줄 1~N 까지
 * F = 맨 아랫줄 16
 * N과 F가 주어질 때, 가장 윗 줄의 수열을 구하라.
 */
public class Main {
    static int[] b, p, check;
    static int n, f;
    static boolean flag = false;
    static int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        b = new int[n];
        p = new int[n];
        check = new int[n+1];

        for(int i=0; i<n; i++) {
            b[i] = comb(n-1, i);
        }

        dfs(0, 0);
    }

    public static int comb(int n, int r) {
        if(dy[n][r] > 0) {
            return dy[n][r];
        }

        if(n == r || r == 0) {
            return 1;
        }

        return dy[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }

    public static void dfs(int L, int sum) {
        if(flag) {
            return;
        }

        if(L == n) {
            if(sum == f) {
                for(int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for(int i=1; i<=n; i++) {
                if(check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    dfs(L+1, sum + p[L] * b[L]);
                    check[i] = 0;
                }
            }
        }
    }
}