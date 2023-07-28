import java.util.*;

/**
 * 경로 탐색(인접리스트)
 * 방향 그래프가 주어지면 1번 정점에서 N번 정점까지 가는 모든 경로의 가지 수를 구하라.
 */
public class Main {
    // N : 정점 개수
    // E : 간선 개수
    // answer : 모든 경로 가지 수
    static int N, E, answer;
    // 인접리스트
    static List<Integer>[] graph;
    // 체크배열
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        graph = new List[N+1];
        visited = new boolean[N+1];

        // 모든 정점의 인접리스트 초기화
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // "from 정점으로부터 to 정점으로 갈 수 있다." 라는 것을 인접리스트로 표현
        for(int i=0; i<E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
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

        // 인접리스트는 인접행렬과 다르게 리스트에 있는 모든 요소들은 이미 갈 수 있는 간선 정보이기 때문에
        // 인접행렬처럼 graph[now][next] == 1 이라는 조건이 필요가 없다.
        for(int next : graph[now]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
                visited[next] = false;
            }
        }
    }
}