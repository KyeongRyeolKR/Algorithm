import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] arrA = new int[a][b];
        int[][] arrB = new int[a+x][b+y];

        for(int i=0; i<a+x; i++) {
            for(int j=0; j<b+y; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<x; i++) {
            System.arraycopy(arrB[i], 0, arrA[i], 0, b);
        }
        for(int i=x; i<a; i++) {
            if (y >= 0) {
                System.arraycopy(arrB[i], 0, arrA[i], 0, y);
            }
        }

        for(int i=x; i<a; i++) {
            for(int j=y; j<b; j++) {
                arrA[i][j] = arrB[i][j] - arrA[i-x][j-y];
            }
        }

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                System.out.print(arrA[i][j]+" ");
            }
            System.out.println();
        }
    }
}