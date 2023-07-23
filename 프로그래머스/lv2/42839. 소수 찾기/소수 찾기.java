import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {

    static HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        recursive("", numbers);

        int max = Collections.max(numberSet);

        boolean[] isPrime = new boolean[max + 1];

        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int x : numberSet) {
            if (isPrime[x]) {
                answer++;
            }
        }

        return answer;
    }

    public static void recursive(String comb, String other) {
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        for (int i = 0; i < other.length(); i++) {
            recursive(comb + other.charAt(i), other.substring(0, i) + other.substring(i + 1));
        }
    }
}