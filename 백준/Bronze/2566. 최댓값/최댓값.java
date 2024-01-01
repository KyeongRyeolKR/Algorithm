import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int row = 9, col = 9;

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                int num = sc.nextInt();
                if(num > max) {
                    max = num;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxRow + " " + maxCol);
    }
}