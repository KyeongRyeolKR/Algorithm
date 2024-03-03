import java.util.Arrays;
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

        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            if(binarySearch(arr, sc.nextInt()) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int key) {
        int lt = 0;
        int rt = arr.length - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;

            if(key < arr[mid]) {
                rt = mid - 1;
            } else if(key > arr[mid]) {
                lt = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}