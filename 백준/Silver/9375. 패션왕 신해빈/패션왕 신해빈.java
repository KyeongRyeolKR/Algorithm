import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int T=0; T<t; T++) {
            int n = sc.nextInt();

            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                String key = sc.next();
                String value = sc.next();
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            int answer = 1;
            for(int value : map.values()) {
                answer *= value + 1;
            }

            System.out.println(answer-1);
        }
    }
}