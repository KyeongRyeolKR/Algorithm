import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int test=0; test<t; test++) {
            int testNo = sc.nextInt();

            int result = 0;

            int[] arr = new int[20];
            for(int i=0; i<20; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i=1; i<20; i++) {
                for(int j=i-1; j>=0; j--) {
                    if(arr[j] > arr[i]) {
                        result++;
                    }
                }
            }

            System.out.println(testNo + " " + result);
        }
    }
}