import java.util.Scanner;

public class Main {
    
    public static int[] arr;
    public static int n;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];

        nQueen(0);
        
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {
            arr[depth] = i;
            
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    public static boolean isPossible(int col) {
        for (int i=0; i<col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}