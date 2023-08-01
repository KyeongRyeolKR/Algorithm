import java.util.*;

/**
 * 선택 정렬
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

        // 마지막은 굳이 볼 필요 없음
        for(int i=0; i<n-1; i++) {
            int index = i;  // index : 바꿔야 할 인덱스(가장 작은 값을 가진 인덱스)
            // j는 현재 인덱스 다음부터 끝까지 반복
            for(int j=i+1; j<n; j++) {
                System.out.println("비교");
                System.out.println("arr[j] = " + arr[j]);
                System.out.println("arr[index] = " + arr[index]);
                System.out.println();
                // 만약 다음 요소가 현재까지 가장 작은 값보다 작을 경우
                if(arr[j] < arr[index]) {
                    index = j;
                }
            }

            System.out.println("현재 가장 작은 인덱스 및 값");
            System.out.println("인덱스 = " + index);
            System.out.println("값 = " + arr[index]);
            System.out.println();
            System.out.println();

            // 끝까지 확인해서 가장 작은 값과 현재 인덱스 값 교환
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}