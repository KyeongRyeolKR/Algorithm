import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        for(int i=0; i<=20; i++) {
            if(k == (int) Math.pow(2, i)) {
                System.out.println(k);
                System.out.println(0);
                return;
            }
        }

        int max = 1;
        for(int i=0; i<=20; i++) {
            if(k < (int) Math.pow(2, i)) {
                max = i;
                break;
            }
        }

        System.out.println((int) Math.pow(2, max));

        int count = 0;
        while(k != 0) {
            int temp = (int) Math.pow(2, --max);
            if(k - temp >= 0) {
                k -= temp;
            }
            count++;
        }
        System.out.println(count);
    }
}