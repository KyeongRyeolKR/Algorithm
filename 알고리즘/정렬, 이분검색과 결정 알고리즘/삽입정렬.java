import java.util.*;

/**
 * 삽입 정렬
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

        /*
        삽입 정렬은 2번째 요소부터 시작한다.
        시작 요소의 값을 temp에 저장한다.
        시작 인덱스 직전부터 1씩 감소하며 반복한다.
        현재 탐색 요소 값이 시작 요소 값보다 크다면, 현재 탐색 요소 다음 값에 현재 탐색 요소 값을 넣어준다.
        반복이 끝나면, 끝난 요소의 다음 요소에 시작 요소의 값을 넣어준다.
         */
        for(int i=1; i<n; i++) {
            int temp = arr[i];
            int j;  // for문 밖에서 j 인덱스 값을 사용하기 위해 미리 선언
            for(j=i-1; j>=0; j--) {
                if(arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j+1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}