import java.util.*;

public class Main {

    static int T, N, count;
    static int[] num;
    static boolean[] visited, finished;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int test=0; test<T; test++) {
            N = sc.nextInt();

            num = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            count = 0;

            for (int i = 1; i <= N; i++) {
                num[i] = sc.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                if(!finished[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - count);
        }
    }

    private static void dfs(int start) {
        if(visited[start]) {
            finished[start] = true;
            count++;
        } else {
            visited[start] = true;
        }

        int next = num[start];
        if(!finished[next]) {
            dfs(next);
        }

        visited[start] = false;
        finished[start] = true;
    }
}