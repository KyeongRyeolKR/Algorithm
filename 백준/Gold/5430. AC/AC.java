import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<>();

            for(int i=0; i<n; i++) {
                deque.add(Integer.valueOf(st.nextToken()));
            }

            AC(command, deque);
        }

        System.out.println(sb);
    }

    private static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        for(char c : command.toCharArray()) {
            if(c == 'R') {
                isRight = !isRight;
                continue;
            }

            if(isRight) {
                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        makeResultString(deque, isRight);
    }

    private static void makeResultString(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append("[");
        if(!deque.isEmpty()) {
            if(isRight) {
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]\n");
    }
}