import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            queue.add(sc.nextLong());
        }

        while(m-->0) {
            long x = queue.poll();
            long y = queue.poll();
            queue.add(x + y);
            queue.add(x + y);
        }

        long total = queue.stream()
                .reduce(Long::sum)
                .get();

        System.out.println(total);
    }
}