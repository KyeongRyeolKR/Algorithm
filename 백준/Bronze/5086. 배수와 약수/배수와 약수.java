import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            String str = sc.nextLine();
            if (str.equals("0 0")) break;
            int[] arr = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if(arr[0] <= arr[1]) {
                boolean[] primes = getPrimes(arr[1]);
                if(primes[arr[0]]) {
                    System.out.println("factor");
                    continue;
                }
            } else {
                int mod = arr[0] % arr[1];
                if(mod == 0) {
                    System.out.println("multiple");
                    continue;
                }
            }
            System.out.println("neither");
        }
    }

    public static boolean[] getPrimes(int n) {
        boolean[] primes = new boolean[n + 1];

        if(n < 2) {
            return null;
        }

        primes[0] = primes[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(primes[i]) {
                continue;
            }

            for(int j = i * i; j < primes.length; j = j+i) {
                primes[j] = true;
            }
        }

        return primes;
    }
}