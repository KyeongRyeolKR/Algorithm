import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int answer = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> divisors = getDivisors(n);

        if(divisors.size() >= k) {
            answer = divisors.get(k-1);
        }

        System.out.println(answer);
    }

    public static List<Integer> getDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (Math.pow(i, 2) == n) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}