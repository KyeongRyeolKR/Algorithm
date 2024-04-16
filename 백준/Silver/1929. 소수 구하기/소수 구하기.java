import java.util.Scanner;

public class Main {
    
    public static boolean[] prime;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        prime = new boolean[n + 1];
        getPrime();

        for(int i = m; i <= n; i++) {
            if(!prime[i]) {
                System.out.println(i);
            }
        }
    }

    public static void getPrime() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) {
                continue;
            }
            
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}