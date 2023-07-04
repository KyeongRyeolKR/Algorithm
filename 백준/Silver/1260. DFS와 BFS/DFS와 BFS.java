import java.util.*;

public class Main {

    static int[][] map;
    static boolean[] visited;
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 시작점

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }

        dfs(V);
        System.out.println();

        visited = new boolean[N+1];

        bfs(V);
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int i=1; i<=N; i++) {
            if(!visited[i] && map[node][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int i=1; i<=N; i++) {
                if(!visited[i] && map[node][i] == 1) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}