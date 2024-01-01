import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n, m;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        inputArray(arr1);
        inputArray(arr2);

        int[][] answer = sumArrays(arr1, arr2);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] sumArrays(int[][] arr1, int[][] arr2) {
        int[][] result = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }

    private static void inputArray(int[][] arr) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }
}