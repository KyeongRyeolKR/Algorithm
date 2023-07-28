import java.util.*;

/**
 * 그래프 최단거리(BFS)
 * 주어진 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 횟수를 구하라.
 */
public class Main {
    // N : 정점 개수
    // E : 간선 개수
    static int N, E;
    // 인접행렬
    static int[][] graph;
    // 최소 이동 횟수를 저장하는 배열
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        graph = new int[N+1][N+1];
        distance = new int[N+1];

        for(int i=0; i<E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 방향 그래프
            graph[a][b] = 1;
        }

        // 시작 정점 : 1
        // 방문했는지 체크하는 배열 대신 distance[i] == 0 이라는 조건으로 탐색하기 때문에,
        // 시작 정점의 최소 이동 횟수 초기 값을 1로 지정했다.
        // 다른 방법으로는 여러가지가 있을 수 있다.
        // 예를 들어, 방문 체크 배열을 만든다거나 Arrays.fill() 메소드로 distance 배열 모든 요소의 초기 값을 -1로 주는 방법이 있다.
        distance[1] = 1;
        bfs(1);

        for(int i=2; i<=N; i++) {
            System.out.println(i + "번 정점 : " + (distance[i]-1));
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);   // 시작

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= N; i++) {
                // 현재 정점에서 i번 정점을 방문 할 수 있다면!
                // 'distance[i] == 0' : 만약 이미 최소 이동 횟수가 저장되어있다면, 굳이 탐색할 필요가 없다.
                if (distance[i] == 0 && graph[now][i] == 1) {
                    queue.add(i);
                    distance[i] = distance[now] + 1; // 다음에 방문할 정점들의 최소 이동 횟수는 현재 정점의 이동 횟수보다 1 증가한다.
                }
            }
        }
    }
}