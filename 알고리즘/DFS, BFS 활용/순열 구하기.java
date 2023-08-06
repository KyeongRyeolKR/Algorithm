import java.util.*;

/**
 * 순열 구하기
 * 10 이하인 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하라.
 * 조건 : 한 순열 안에 중복된 숫자가 있으면 안됨
 */
public class Main {
    // N : 총 숫자 개수
    // M : 총 뽑는 개수
    static int N, M;
    static int[] arr; // 모든 숫자 배열
    static int[] result; // 순열로 뽑힌 배열
    static boolean[] used; // 사용했는지 체크 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        result = new int[M];
        used = new boolean[N];

        dfs(0);
    }

    private static void dfs(int picked) {
        // 원하는 개수만큼 다 뽑았을 때
        if(picked == M) {
            for(int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            // 모든 숫자들을 탐색하면서 만약 해당 숫자를 사용 안했다면
            for(int i=0; i<N; i++) {
                if(!used[i]) {
                    used[i] = true; // 사용 처리
                    result[picked] = arr[i]; // 해당 숫자를 순열에 넣어줌
                    dfs(picked+1); // 다음 재귀
                    used[i] = false; // 사용 해제
                }
            }
        }
    }
}