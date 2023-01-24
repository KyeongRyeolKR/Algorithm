import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            if(n % h == 0){
                System.out.println((h * 100) + (n / h));
            } else {
                System.out.println(((n % h) * 100) + ((n / h) + 1));
            }
        }
    }
}