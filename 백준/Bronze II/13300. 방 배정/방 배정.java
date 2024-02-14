import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = sc.nextInt();

        int[][] arr = new int[6][2];
        for(int i=0; i<n; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            arr[grade-1][gender]++;
        }

        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] != 0) {
                    if(arr[i][j] % max == 0) {
                        count += arr[i][j] / max;
                    } else {
                        count += arr[i][j] / max + 1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}