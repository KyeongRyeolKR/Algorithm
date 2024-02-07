import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String command = br.readLine();
            int value = 0;
            if(command.startsWith("push")) {
                String[] split = command.split(" ");
                command = split[0];
                value = Integer.parseInt(split[1]);
            }

            execute(command, value);
        }
    }

    private static void execute(String command, int value) {
        switch (command) {
            case "push_front":
                deque.addFirst(value);
                break;
            case "push_back":
                deque.addLast(value);
                break;
            case "pop_front":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
                break;
            case "pop_back":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
                break;
            case "size":
                System.out.println(deque.size());
                break;
            case "empty":
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                break;
            case "front":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
                break;
            case "back":
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
                break;
        }
    }
}