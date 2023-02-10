import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] lengths = {64, 32, 16, 8, 4, 2, 1};

        int n = sc.nextInt();

        int cnt = 0;
        for (int length : lengths) {
            if (n == length) {
                cnt++;
                break;
            } else if (n - length > 0) {
                n -= length;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}