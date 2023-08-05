import java.util.*;

/**
 * 중복순열 구하기
 * 1부터 N까지 번호가 있다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력하라.
 */
public class Main {

    // N : 1~N까지 숫자
    // M : 몇개의 숫자를 뽑는지
    static int N, M;
    // 뽑은 숫자 배열
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(0);
    }

    private static void dfs(int picked) {
        // 뽑은 숫자가 M개가 됐다면 다 뽑은거니까 출력하기
        if(picked == M) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=N; i++) {
                arr[picked] = i;
                dfs(picked+1);
            }
        }
    }
}