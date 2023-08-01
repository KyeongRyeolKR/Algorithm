import java.util.*;

/**
 * 버블 정렬
 * N개 숫자를 오름차순하기
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // 마지막 요소는 비교 할 필요 없음
        for(int i=0; i<n-1; i++) {
            // for(i) 반복이 끝날 때 마다 맨 뒤(가장 큰 값)가 결정되기 때문에 -i 해줘야 함
            for(int j=0; j<n-1-i; j++) {
                // 만약 앞 요소가 뒷 요소 값보다 클 경우
                if(arr[j] > arr[j+1]) {
                    // 앞 뒤 값 스왑
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}