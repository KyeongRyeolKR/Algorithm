import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] times = new int[n];
        for(int i=0; i<n; i++) {
            times[i] = sc.nextInt();
        }

        Arrays.sort(times);

        int total = 0;
        for(int i=0; i<times.length; i++) {
            for(int j=0; j<=i; j++) {
                total += times[j];
            }
        }

        System.out.println(total);
    }
}