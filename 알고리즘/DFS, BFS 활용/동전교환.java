import java.util.*;

/**
 * 동전교환
 * 여러 단위의 동전들이 주어질 때,
 * 거스름돈을 가장 적은 수의 동전으로 교환해주는 방법을 출력하라.
 */
public class Main {
    // N : 동전 종류의 개수
    // M : 거슬러 줄 금액
    static int N, M;
    // answer : 필요한 동전의 최소 개수
    static int answer = Integer.MAX_VALUE;
    // 동전 종류
    static int[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        coins = new int[N];
        for(int i=0; i<N; i++) {
            coins[i] = sc.nextInt();
        }

        M = sc.nextInt();

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int picked, int sum) {
        // 현재까지의 총 금액이 거슬러줘야 할 돈보다 많아지면 더이상 재귀 안하게 종료
        if(sum > M) {
            return;
        }
        // 총 금액이 거슬러줘야 할 돈이랑 같다면,
        // 지금 동전을 뽑은 갯수와 이미 저장되어있는 answer와 비교해서 작은 걸 답으로 저장
        if(sum == M) {
            answer = Math.min(picked, answer);
        } else {
            for(int i=0; i<N; i++) {
                dfs(picked+1, sum+coins[i]);
            }
        }
    }
}