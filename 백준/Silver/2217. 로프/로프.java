import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;

        int n = sc.nextInt();
        int[] weights = new int[n];
        for(int i=0; i<n; i++) {
            weights[i] = sc.nextInt();
            max = Math.max(weights[i], max);
        }

        Arrays.sort(weights);
        if(n == 2) {
            System.out.println(weights[0] * 2);
            return;
        }

        for(int i=weights.length-1; i>=1; i--) {
            int pickCount = n - i;
            max = Math.max(max, weights[i] * pickCount);
        }

        System.out.println(max);
    }
}