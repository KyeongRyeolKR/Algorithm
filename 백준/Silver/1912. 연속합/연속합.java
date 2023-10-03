import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        if(Arrays.stream(arr).max().getAsInt() < 0) {
            System.out.println(Arrays.stream(arr).max().getAsInt());
            return;
        }

        int max = Integer.MIN_VALUE;
        int total = 0;

        for(int i=0; i<n; i++) {
            if(total + arr[i] >= 0) {
                total += arr[i];
                max = Math.max(total, max);
            } else {
                total = 0;
            }
        }

        System.out.println(max);
    }
}