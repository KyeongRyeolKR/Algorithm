import java.util.*;

/**
 * Least Recently Used(선택정렬 응용 문제)
 * 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면
 * N개의 작업을 처리한 후 캐시 메모리의 상태를 가장 최근 사용한 작업부터 차례대로 출력하라.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] task = new int[n];
        for(int i=0; i<n; i++) {
            task[i] = sc.nextInt();
        }

        int[] cache = new int[size];

        for(int x : task) {
            System.out.println("현재 작업 값 = " + x);
            int pos = -1;
            for(int i=0; i<size; i++) {
                if(x == cache[i]) {
                    pos = i;
                }
            }

            if(pos == -1) {
                for(int i=size-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }

            } else {
                for(int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;

            System.out.println("현재 캐시 메모리 상태");
            System.out.println(Arrays.toString(cache));
            System.out.println();
        }
    }
}