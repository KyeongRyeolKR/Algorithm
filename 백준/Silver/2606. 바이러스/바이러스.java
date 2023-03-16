import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Integer>[] a;
    static boolean[] visit;
    static int count;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new ArrayList[n+1];
        visit = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }


        System.out.println(dfs(1));
    }


    public static int dfs(int x) {
        visit[x] = true;

        for (int y : a[x]) {
            if (visit[y] == false) {
                count++;
                dfs(y);
            }
        }
        return count;
    }
}