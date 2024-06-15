import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();
        
        Queue<Integer> truck = new LinkedList<>();
        for(int i=0; i<n; i++) {
            truck.offer(sc.nextInt());
        }

        int time = 0;
        int bw = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<w; i++) {
            q.add(0);
        }

        while(!q.isEmpty()) {
            time++;
            bw -= q.poll();
            if(!truck.isEmpty()) {
                if(truck.peek() + bw <= L) {
                    bw+=truck.peek();
                    q.offer(truck.poll());
                } else {
                    q.offer(0);
                }
            }
        }
        
        System.out.println(time);
    }
}