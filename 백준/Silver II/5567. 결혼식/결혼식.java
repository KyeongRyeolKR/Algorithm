import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m, count;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n+1];
        visited[1] = true;

        dfs(1, 0);

        for(int i=2; i<visited.length; i++) {
            if(visited[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int num, int depth) {
        if(depth == 2) {
            return;
        }

        for(int i=0; i<list[num].size(); i++) {
            int next = list[num].get(i);
            visited[next] = true;
            dfs(next, depth+1);
        }
    }
}