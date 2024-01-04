import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            int n = sc.nextInt();

            if(n == -1) {
                break;
            }

            List<Integer> divisors = getDivisors(n);
            int sum = divisors.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            if(sum == n*2) {
                System.out.print(n + " = ");
                for(int i=0; i<divisors.size(); i++) {
                    if(i == divisors.size() - 2) {
                        System.out.println(divisors.get(i));
                        break;
                    }
                    System.out.print(divisors.get(i) + " + ");
                }
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
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