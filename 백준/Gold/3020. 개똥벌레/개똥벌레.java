import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();

        int[] s = new int[h+1];
        int[] j = new int[h+1];

        for(int i=0; i<n/2; i++) {
            int sh = sc.nextInt();
            int jh = sc.nextInt();
            s[sh]++;
            j[jh]++;
        }

        for(int i=h; i>0; i--) {
            s[i-1] = s[i] + s[i-1];
            j[i-1] = j[i] + j[i-1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i=1; i<=h; i++) {
            int temp = s[i] + j[h+1-i];
            if(temp < min) {
                min = temp;
                count = 1;
            } else if(temp == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}