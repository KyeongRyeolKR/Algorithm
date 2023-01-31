import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트 케이스 수
        for (int i = 0; i < T; i++) {   // 테스트 케이스만큼 반복함
            int floorNum = sc.nextInt();    // 구하려는 층
            int roomNum = sc.nextInt();     // 구하려는 호

            // 0층의 n호까지의 배열 초기화 및 선언 ( 1,2,3,4,....,n )
            int[] zero = new int[roomNum];
            for (int j = 0; j < roomNum; j++) {
                zero[j] = j + 1;
            }

            // 재귀 시작
            nextArr(zero, roomNum, floorNum);
        }
    }

    /*
    ex) 3층, 5호
        1. nextArr(0층배열, 5호, 3층) -> 재귀 시작
        2. nextArr(1층배열, 5호, 2층)
        3. nextArr(2층배열, 5호, 1층)
        4. nextArr(3층배열, 5호, 0층) -> 결과값 도출 및 재귀 탈출
     */
    public static void nextArr(int[] arr, int roomNum, int floorNum) {
        int[] next = new int[roomNum];  // 다음 층 배열 선언
        next[0] = 1;    // 몇 층이든 첫번째 호는 1명임
        for (int i = 1; i < roomNum; i++) {     // 다음 층 배열에 들어갈 값들을 구하려는 호 까지 반복
            next[i] = next[i - 1] + arr[i];     // 규칙 : '다음 층의 i번째 방'은 '다음 층의 i-1번 방'과 '직전 층의 i번'을 합친 값임
        }

        if (floorNum == 0) {    // 재귀적으로 층을 -1씩 하다가 floorNum 이 0이 되면 결과를 출력하고 재귀 탈출
            System.out.println(arr[roomNum - 1]);   // 해당 층 배열의 마지막 값 출력 (결과값)
            return;
        }
        nextArr(next, roomNum, floorNum - 1);   // floorNum 이 0이 될 때 까지 재귀
    }
}