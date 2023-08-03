import java.util.*;

/**
 * 마구간 정하기(결정알고리즘)
 * N개의 마구간이 수직선상에 있다.
 * C마리의 말을 마구간에 배치하고 싶은데 가장 가까운 두 말의 거리가 최대가 되게 하고 싶다.
 * 가장 가까운 두 말의 거리가 최대 거리를 구하라.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 마구간 수
        int c = sc.nextInt(); // 말 수

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        // 가능한 최소 거리는 1
        int lt = 1;
        // 가능한 최대 거리는 가장 먼 좌표
        // ps) 원래 최대 거리는 (가장 큰 좌표 - 가장 작은 좌표) 이지만,
        //     어차피 이분탐색으로 하기 때문에 속도 차이가 거의 없다.
        int rt = arr[n-1];
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            // 배치할 수 있는 말이 내가 가진 말보다 많다면
            if(count(arr, mid) >= c) {
                answer = mid; // 답을 현재 거리로 설정
                lt = mid + 1; // 거리가 더 멀어질 수 있는지 확인하기 위해 범위 좁히기
            } else {
                rt = mid - 1; // 현재 거리로는 안되기 때문에 거리를 더 좁혀봄
            }
        }

        System.out.println(answer);
    }

    public static int count(int[] arr, int dist) {
        int count = 1; // 배치한 마리 수
        int endPos = arr[0]; // 마지막 배치한 말의 좌표
        for(int i=1; i<arr.length; i++) {
            // 만약 두 말의 거리가 내가 설정한 최소 거리보다 크다면,
            // 말을 배치하고 마지막 배치한 말의 좌표를 바꿔준다.
            if(arr[i] - endPos >= dist) {
                count++; // 배치한 마리수 증가
                endPos = arr[i]; // 마지막 배치한 말의 좌표 수정
            }
        }
        return count;
    }
}