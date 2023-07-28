import java.util.*;

/**
 * 경로 탐색(인접행렬)
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점까지 가는 모든 경로의 가지 수를 구하라.
 */
public class Main {
    // N : 정점 개수
    // E : 간선 개수
    // answer : 모든 경로 가지 수
    static int N, E, answer;
    // 인접행렬
    static int[][] graph;
    // 체크배열
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 방향 그래프이기 때문에 한 방향으로만 1 저장
            graph[a][b] = 1;
        }

        // 시작 정점 : 1
        visited[1] = true;
        dfs(1);

        System.out.println("답 = " + answer);
    }

    private static void dfs(int now) {
        // 만약 현재 정점이 끝 정점과 같다면, 경로 가지 수 1 증가
        if(now == N) {
            answer++;
        }

        // 현재 정점에서 다음 정점으로 갈 수 있는지 순회하며 탐색
        for (int i = 1; i <= N; i++) {
            // i번 정점으로 갈 수 있는 조건
            if (!visited[i] && graph[now][i] == 1) {
                visited[i] = true;  // 방문할거니까 체크
                dfs(i); // 다음 정점 탐색
                visited[i] = false; // 끝까지 갔다가 백트래킹을 하기 위해 방문 체크 해제
            }
        }
    }
}