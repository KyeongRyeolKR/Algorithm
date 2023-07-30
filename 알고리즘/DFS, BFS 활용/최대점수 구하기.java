import java.util.*;

/**
 * 최대점수 구하기(DFS)
 * N 개의 문제와 각 문제를 풀었을 때의 점수와 걸리는 시간이 주어진다.
 * 제한시간 M 안에 N 개의 문제 중 얻을 수 있는 최대 점수를 구하라.
 */
public class Main {
    // N : 문제 개수
    // M : 제한 시간
    // answer : 얻을 수 있는 최대 점수
    static int N, M, answer;
    // 각 문제마다 얻는 점수, 걸리는 시간을 2차원 배열로 나타냄
    static int[][] questions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        questions = new int[N][2];
        for(int i=0; i<N; i++) {
            questions[i][0] = sc.nextInt();
            questions[i][1] = sc.nextInt();
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int count, int totalScore, int totalTime) {
        // 현재까지 총 걸린 시간이 제한 시간을 넘는다면 더이상 탐색할 필요 없음
        if(totalTime > M) {
            return;
        }
        // 모든 문제를 탐색했다면
        if(count == N) {
            // 최대 점수 갱신
            answer = Math.max(totalScore, answer);
        } else {
            // 현재 문제를 풀었을 때
            dfs(count+1, totalScore+questions[count][0], totalTime+questions[count][1]);
            // 현재 문제를 안풀었을 때
            dfs(count+1, totalScore, totalTime);
        }
    }
}