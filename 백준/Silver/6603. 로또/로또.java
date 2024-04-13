import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int num;
    static int[] arr;
    static int[] picked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            num = sc.nextInt();
            if (num == 0) {
                break;
            }

            arr = new int[num];
            picked = new int[6];

            for(int i=0; i<num; i++) {
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int index, int count) {
        if(count == 6) {
            for(int i=0; i<6; i++) {
                System.out.print(picked[i] + " ");
            }
            System.out.println();
            return;
        }

        if(index == num) {
            return;
        }

        for(int i=index; i<num; i++) {
            picked[count] = arr[i];
            dfs(i+1, count+1);
        }
    }
}