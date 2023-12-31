import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i + 1;
        }

        for(int i=0; i<m; i++) {
            int index1 = sc.nextInt() - 1;
            int index2 = sc.nextInt() - 1;
            swap(index1, index2);
        }

        print(arr);
    }

    public static void swap(int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void print(int[] arr) {
        Arrays.stream(arr)
                .mapToObj(num -> num + " ")
                .forEach(System.out::print);
    }
}