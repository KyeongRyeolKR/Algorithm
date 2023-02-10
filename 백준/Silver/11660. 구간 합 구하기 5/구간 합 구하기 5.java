import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int problem = sc.nextInt();

        int[][] numberArr = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                numberArr[i][j] = sc.nextInt();
            }
        }

        int[][] prefixSumArr = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                prefixSumArr[i][j] = prefixSumArr[i - 1][j] + prefixSumArr[i][j - 1] - prefixSumArr[i - 1][j - 1] + numberArr[i][j];
            }
        }

        int[][] problemArr = new int[problem][4];
        for (int i = 0; i < problemArr.length; i++) {
            for (int j = 0; j < problemArr[i].length; j++) {
                problemArr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < problemArr.length; i++) {
            int x1 = problemArr[i][0];
            int y1 = problemArr[i][1];
            int x2 = problemArr[i][2];
            int y2 = problemArr[i][3];

            int result = prefixSumArr[x2][y2] - prefixSumArr[x2][y1 - 1] - prefixSumArr[x1 - 1][y2] + prefixSumArr[x1 - 1][y1 - 1];
            System.out.println(result);
        }

    }
}