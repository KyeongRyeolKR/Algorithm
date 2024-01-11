import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        Integer[] A = new Integer[n];
        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        Integer[] B = new Integer[n];
        for(int i=0; i<n; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int answer = 0;
        for(int i=0; i<n; i++) {
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}