import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=size; i++) {
            queue.offer(i);
        }

//        IntStream.rangeClosed(1,size).forEach(queue::offer);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            for(int i=0; i<k; i++) {
                if(i != k-1) {
                    queue.offer(queue.poll());
                } else {
                    sb.append(queue.poll());
                }
            }
            if(!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}