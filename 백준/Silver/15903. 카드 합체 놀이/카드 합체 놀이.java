import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] cards = new long[n];
        for(int i=0; i<n; i++) {
            cards[i] = sc.nextInt();
        }

        while(m-->0) {
            Arrays.sort(cards);
            long temp = cards[0] + cards[1];
            cards[0] = temp;
            cards[1] = temp;
        }

        long total = Arrays.stream(cards).sum();

        System.out.println(total);
    }
}