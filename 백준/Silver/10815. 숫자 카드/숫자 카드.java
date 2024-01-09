import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(sc.nextInt(), 0);
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            if(map.get(sc.nextInt()) != null) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}