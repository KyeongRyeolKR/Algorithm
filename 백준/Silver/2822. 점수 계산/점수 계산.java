import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int sum = 0; 
        int[][] scores = new int[8][2]; 
        int[] picks = new int[5];

        for(int i=0; i<8; i++) {
            scores[i][0] = sc.nextInt(); 
            scores[i][1] = i+1; 
        }

        Arrays.sort(scores, (a, b) -> b[0] - a[0]);

        for(int i=0; i< 5; i++) {
            sum += scores[i][0];
            picks[i] = scores[i][1];
        }

        Arrays.sort(picks);

        System.out.println(sum);

        for(int i=0; i<5; i++) {
            System.out.print(picks[i] + " ");
        }
    }
}