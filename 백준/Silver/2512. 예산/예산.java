import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int left = 0;
        int right = -1;
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            
            right = Math.max(right, arr[i]);
        }

        int m = sc.nextInt();
        while(left <= right) {
            int mid = (left + right) / 2;
            long budget =0;
            for(int i=0; i<n; i++) {
                budget += Math.min(arr[i], mid);
            }

            if(budget <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}