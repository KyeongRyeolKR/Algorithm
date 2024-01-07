import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int first = 666;
        while(true) {
            String S = String.valueOf(first);

            for(int i = 0; i < S.length() - 2; i++) {
                if(S.charAt(i) == '6' && S.charAt(i + 1) == '6' && S.charAt(i + 2) == '6') {
                    n--;
                    break;
                }
            }

            if(n == 0) break;
            first++;
        }
        System.out.println(first);
    }
}