import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] credits = new int[N];
            double[] scores = new double[N];
            for (int j = 0; j < N; j++) {
                credits[j] = sc.nextInt();
                scores[j] = sc.nextDouble();
            }

            int creditsSum = 0;
            double scoresSum = 0.0;
            for (int j = 0; j < N; j++) {
                scoresSum += credits[j] * scores[j];
                creditsSum += credits[j];
            }
            System.out.printf("\n%d %.1f\n", creditsSum, scoresSum/creditsSum);
        }


    }
}