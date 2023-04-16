import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;
        int count = 0;
        while(lt < rt) {
            if(arr[lt] + arr[rt] == x) {
                count++;
                lt++;
                rt--;
            } else if(arr[lt] + arr[rt] > x) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(count);
    }
}