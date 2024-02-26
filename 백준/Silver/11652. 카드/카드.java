import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Long, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            long key = sc.nextLong();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long answer = 0;
        for(long card : map.keySet()) {
            int count = map.get(card);
            if(count > max) {
                max = count;
                answer = card;
            } else if(count == max) {
                answer = Math.min(answer, card);
            }
        }

        System.out.println(answer);
    }
}