import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[46];
        arr[0] = 0;
        arr[1] = 1;

        // f2 = f0 + f1
        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        System.out.println(arr[n]);
    }
}