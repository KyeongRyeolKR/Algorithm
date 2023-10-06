import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] lengths;
    static int start, end, mid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        lengths = new int[n];
        for(int i=0; i<n; i++) {
            lengths[i] = sc.nextInt();
        }

        start = Arrays.stream(lengths).max().orElseThrow();
        end = Arrays.stream(lengths).sum();
        mid = 0;

        binarySearch();

        System.out.println(start);
    }

    /**
     * 이진탐색
     * start == 최소 블루레이 크기
     * end == 최대 블루레이 크기
     * mid == 개당 블루레이 크기
     *
     * 필요한 블루레이 수량이 내가 가지고 있는 블루레이 수량보다 작으면,
     * 현재 블루레이 크기가 너무 큰 것이므로 최대 블루레이 크기를 (mid - 1)로 줄임
     *
     * 필요한 블루레이 수량이 내가 가지고 있는 블루레이 수량보다 크면,
     * 현재 블루레이 크기가 너무 작은 것으므로 최소 블루레이 크기를 (mid + 1)로 늘림
     */
    private static void binarySearch() {
        while(start <= end) {
            mid = (start + end) / 2;

            int bluerayCount = getBluerayCount();

            if(bluerayCount > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    /**
     * mid 보다 작을때까지 누적합.
     * 만약 mid 보다 커지면 블루레이 수량 1개 증가 및 sum 초기화
     * @return 필요한 블루레이 수량
     */
    private static int getBluerayCount() {
        int count = 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(sum + lengths[i] > mid) {
                count++;
                sum = 0;
            }
            sum += lengths[i];
        }
        return count;
    }
}