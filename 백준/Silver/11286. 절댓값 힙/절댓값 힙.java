import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static PriorityQueue<Long> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) {
                return (int) (o1 - o2);
            }
            return (int) (Math.abs(o1) - Math.abs(o2));
        });
        
        for(int i=0; i<n; i++) {
            long input = sc.nextInt();

            if(input == 0) {
                print();
            } else {
                pq.add(input);
            }
        }
    }

    private static void print() {
        if(pq.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(pq.poll());
    }
}
