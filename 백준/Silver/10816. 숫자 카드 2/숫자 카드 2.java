import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int key = sc.nextInt();
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');

        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (key <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (key < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return low;
    }

}