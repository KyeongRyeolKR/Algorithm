import java.util.Scanner;

/**
 * 조합 구하기
 * 1부터 N까지의 숫자 중 M개를 뽑는 방법의 수를 구하라
 */
public class Main {
    static int[] comb;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        comb = new int[m];

        dfs(0, 1);
    }

    public static void dfs(int level, int num) {
        if(level == m) {
            for(int x : comb) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=num; i<=n; i++) {
                comb[level] = i;
                dfs(level+1, i+1);
            }
        }
    }
}