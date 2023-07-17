import java.util.Scanner;

public class Main {

    static int N;
    static int[][] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        answer = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                answer[i][j] = sc.nextInt();
            }
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(answer[i][k] == 1 && answer[k][j] == 1) {
                        answer[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}