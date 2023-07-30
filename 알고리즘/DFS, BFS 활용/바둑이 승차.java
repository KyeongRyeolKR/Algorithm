import java.util.*;

/**
 * 바둑이 승차(DFS)
 * 철수는 그의 바둑이들을 트럭에 태우려고 한다.
 * 트럭은 C kg 넘게 태울 수 없고, 철수는 최대한 무겁게 태우고 싶다.
 * N 마리의 바둑이와 각 바둑이의 무게 W가 주어질 때 가장 무거운 무게를 구하라.
 */
public class Main {
    // C : 트럭 최대 무게
    // N : 바둑이 마리 수
    // answer : 가장 무겁게 태운 무게
    static int C, N, answer;
    // 바둑이들의 각 무게 배열
    static int[] weights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();

        weights = new int[N];
        for(int i=0; i<N; i++) {
            weights[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int count, int sum) {
        // 만약 현재까지의 합이 C보다 크다면 더이상 재귀를 할 필요 없음
        if(sum > C) {
            return;
        }

        // 모든 바둑이 탐색을 다 했다면
        if(count == N) {
            // 최대 값 갱신
            answer = Math.max(answer, sum);
        } else {
            // 현재 바둑이를 태우고, 다음 바둑이 탐색
            dfs(count+1, sum+weights[count]);
            // 현재 바둑이를 안태우고, 다음 바둑이 탐색
            dfs(count+1, sum);
        }
    }
}