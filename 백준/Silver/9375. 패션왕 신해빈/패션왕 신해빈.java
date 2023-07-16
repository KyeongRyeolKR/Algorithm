import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T -- > 0) {

            HashMap<String, Integer> hm = new HashMap<>();

            int N = sc.nextInt();

            while (N-- > 0) {

                sc.next();

                String kind = sc.next();

                if (hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind) + 1);
                }
                else {
                    hm.put(kind, 1);
                }
            }

            int result = 1;
            for (int val : hm.values()) {
                result *= (val + 1);
            }

            System.out.println(result - 1);

        }

    }

}