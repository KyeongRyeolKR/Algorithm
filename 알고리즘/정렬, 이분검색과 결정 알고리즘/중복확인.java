import java.util.*;

/**
 * 중복 확인(정렬)
 * 1 ~ 10,000,000까지의 자연수 중 N개의 숫자를 뽑았다.
 * N개의 자연수 중에 중복이 존재하면 D, 존재하지 않는다면 U를 출력하라.
 * -> 일반적으로 중복 확인을 위해 HashSet을 사용하면 되지만
 *    정렬을 사용해 문제를 풀어보자.
 *    (HashSet을 사용하면 o(n)의 시간복잡도지만, 정렬은 시간복잡도가 o(nlogn)으로 효율이 안좋다)
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        String answer = "U";

        Arrays.sort(arr);

        for(int i=0; i<n-1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
                break;
            }
        }

        System.out.println(answer);
    }
}