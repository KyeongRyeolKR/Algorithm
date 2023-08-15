import java.util.*;

/**
 * 조합수(메모이제이션)
 *
 *                  5 C 3
 *          4 C 2     +      4 C 3
 *      3 C 1 + 3 C 2    3 C 2 + 3 C 3
 *                   ...
 */
public class Main {

    static int N, R;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();

        // 최대 수 = 35
        arr = new int[35][35];

        System.out.println(dfs(N, R));
    }

    private static int dfs(int n, int r) {
        // 만약 배열에 이미 기록된 값이 있다면 해당 값을 리턴
        if(arr[n][r] > 0) {
            return arr[n][r];
        }

        // n과 r이 같거나 r이 0이라면 1
        if(n == r || r == 0) {
            return 1;
        } else {
            return arr[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
        }
    }
}