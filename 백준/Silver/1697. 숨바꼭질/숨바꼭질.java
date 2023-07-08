import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] map;
    static int a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        map = new int[100001];

        if(a == b) {
            System.out.println(0);
        } else {
            System.out.println(bfs(a));
        }
    }

    private static int bfs(int now) {
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        map[now] = 1;

        while(!q.isEmpty()) {
            int pos = q.poll();

            for(int i=0; i<3; i++) {
                int next = 0;

                if(i==0) {
                    next = pos + 1;
                } else if(i==1) {
                    next = pos - 1;
                } else {
                    next = pos * 2;
                }

                if(next == b) {
                    return map[pos];
                }

                if(next >= 0 && next < map.length && map[next] == 0) {
                    q.add(next);
                    map[next] = map[pos] + 1;
                }
            }
        }

        return -1;
    }
}