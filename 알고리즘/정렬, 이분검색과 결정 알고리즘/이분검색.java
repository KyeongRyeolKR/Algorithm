import java.util.*;

/**
 * 이분검색
 * N개의 숫자들과 그 숫자들 중 한개인 M이 주어진다.
 * 이 숫자들을 오름차순으로 정렬된 상태에서 M이 몇 번째에 있는지 구하라.
 * 단, 중복 값은 존재하지 않는다.
 * -> 중간 값을 계속 확인해보며 범위를 좁혀나가는 탐색 방식
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == m) {
                System.out.println("정렬된 arr = " + Arrays.toString(arr));
                System.out.println("답 = " + (mid + 1) + "번째");
                break;
            } else if (arr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
    }
}