import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
        }

        int decreaseCount = 0;
        for(int i=scores.length-1; i>=1; i--) {
            while(scores[i] <= scores[i-1]) {
                scores[i-1] -= 1;
                decreaseCount++;
            }
        }

        System.out.println(decreaseCount);
    }
}