import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int a, int b) {
        // a와 b의 최대공약수
        int gcd = getGCD(a, b);

        // 기약분수로 만들기
        if(gcd != 1) {
            a = a / gcd;
            b = b / gcd;
        }
        
        // 분모의 소인수들을 구하고, 소인수 중 2 또는 5가 아닌것이 있다면 count 증가
        List<Integer> denominatorPrimes = getPrimes(b);
        int count = 0;
        for (int x : denominatorPrimes) {
            if (!checkTwoOrFive(x)) {
                count++;
            }
        }
        return count > 0 ? 2 : 1;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return getGCD(num2, num1%num2);
    }

    public static List<Integer> getPrimes(int num) {
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<=num; i++) {
            if(num % i == 0) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static boolean checkTwoOrFive(int num) {
        return num % 2 == 0 || num % 5 == 0;
    }
}