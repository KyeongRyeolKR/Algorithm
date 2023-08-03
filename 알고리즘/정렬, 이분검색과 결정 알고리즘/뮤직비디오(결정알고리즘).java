import java.util.*;

/**
 * 뮤직비디오(결정알고리즘)
 * N개의 노래와 M개의 CD가 있다.
 * M개의 CD에 N개의 노래를 나눠서 담아야 한다.
 * CD에 노래를 담을 땐, 꼭 순서대로 담아야한다.
 * N개의 노래를 M개의 CD에 담을 때, 필요한 CD의 최소 용량을 구하라.
 * -> 결정 알고리즘은 아무때나 막 사용하면 안되고
 *    주어진 범위 내에 답이 있다고 확신할 떄만 사용해야한다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노래 수
        int m = sc.nextInt(); // CD 수

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;

        // 최초 lt 값은 모든 노래 길이 중 최대 값이다.
        // 최초 rt 값은 모든 노래 길이의 합이다.
        // -> 최소 1개의 CD에 가장 긴 길이를 가진 노래를 담을 수 있어야하고,
        //    최대 1개의 한 CD에 모든 노래들을 담을 수 있어야 하기 때문
        int lt = Arrays.stream(arr).max().orElse(0);
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 지정된 최대 저장 값으로 최소 몇개의 cd를 사용해서 담을 수 있는지
    public static int count(int[] arr, int capacity) {
        int count = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x <= capacity) {
                sum += x;
            } else {
                count++;
                sum = x;
            }
        }
        return count;
    }
}