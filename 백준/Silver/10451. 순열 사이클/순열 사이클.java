import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int T, N, cycle;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int test=0; test<T; test++) {
            N = sc.nextInt();
            visited = new boolean[N + 1];

            list = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
                list[i].add(sc.nextInt());
            }

            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    dfs(i);
                    cycle++;
                }
            }
            System.out.println(cycle);
            cycle = 0;
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int x : list[node]) {
            if(!visited[x]) {
                dfs(x);
            }
        }
    }
}