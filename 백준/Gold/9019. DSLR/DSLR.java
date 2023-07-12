import java.util.*;

public class Main {

    static int T, A, B;
    static String[] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int test=0; test<T; test++) {
            A = sc.nextInt();
            B = sc.nextInt();

            map = new String[10000];
            visited = new boolean[10000];
            Arrays.fill(map, "");
            
            bfs(A);

            System.out.println(map[B]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty() && !visited[B]) {
            int now = q.poll();
            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = now % 1000 * 10 + now / 1000;
            int R = now % 10 * 1000 + now / 10;

            if(!visited[D]) {
                q.add(D);
                visited[D] = true;
                map[D] = map[now] + "D";
            }

            if(!visited[S]) {
                q.add(S);
                visited[S] = true;
                map[S] = map[now] + "S";
            }

            if(!visited[L]) {
                q.add(L);
                visited[L] = true;
                map[L] = map[now] + "L";
            }

            if(!visited[R]) {
                q.add(R);
                visited[R] = true;
                map[R] = map[now] + "R";
            }
        }
    }
}