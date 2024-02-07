import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static LinkedList<Integer> deque = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=1; i<=n; i++) {
            deque.add(i);
        }

        int[] order = new int[m];
        for(int i=0; i<m; i++) {
            order[i] = sc.nextInt();
        }

        for(int i=0; i<m; i++) {
            int targetIndex = deque.indexOf(order[i]);
            int mid = getMiddleIndex();

            execute(targetIndex, mid);

            deque.pollFirst();
        }

        System.out.println(count);
    }

    private static void execute(int targetIndex, int mid) {
        if(targetIndex <= mid) {
            for(int i=0; i<targetIndex; i++) {
                int temp = deque.pollFirst();
                deque.addLast(temp);
                count++;
            }
        } else {
            for(int i=0; i<deque.size()-targetIndex; i++) {
                int temp = deque.pollLast();
                deque.addFirst(temp);
                count++;
            }
        }
    }

    private static int getMiddleIndex() {
        return deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;
    }
}