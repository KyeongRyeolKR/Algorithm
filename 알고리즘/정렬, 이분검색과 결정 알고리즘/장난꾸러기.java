import java.util.*;

/**
 * 장난꾸러기
 * 철수네 반에는 N명의 학생들이 있다.
 * 선생님은 학생들을 키 순서대로 줄을 세우고 번호를 부여한다.
 * 그런데 장난꾸러기 철수는 짝꿍보다 키가 크지만, 앞 번호를 받고 싶어서 짝꿍과 자리를 바꿨다.
 * 철수와 짝꿍이 받은 번호를 차례대로 출력하라.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 학생 수

        int[] heights = new int[n]; // 학생들이 일렬로 서있는 키 정보
        for(int i=0; i<n; i++) {
            heights[i] = sc.nextInt();
        }

        int[] temp = Arrays.copyOf(heights, n); // 원래 키 정보 복사

        Arrays.sort(heights); // 철수가 마음대로 바꾼 줄을 키 순서대로 정렬

        for(int i=0; i<n; i++) {
            // 두 배열 값이 다르면 철수 혹은 짝꿍의 번호 출력
            if(heights[i] != temp[i]) {
                System.out.print(i+1 + " ");
            }
        }
    }
}