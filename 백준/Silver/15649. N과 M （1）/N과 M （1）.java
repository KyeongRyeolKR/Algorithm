import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        used = new boolean[n];

        dfs(0);
    }

    public static void dfs(int depth) {
        if(depth == m) {
            for(int val : arr) {
                System.out.print(val + " ");
            }

            System.out.println();

            return;
        }

        for(int i=0; i<n; i++) {
            if(!used[i]) {
                used[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }
}