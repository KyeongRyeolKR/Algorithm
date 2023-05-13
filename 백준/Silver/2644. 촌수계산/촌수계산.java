import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[] counts;
    static int nodes;
    static int start;
    static int end;
    static int lines;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nodes = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        lines = sc.nextInt();

        map = new int[nodes+1][nodes+1];
        for(int i=1; i<=lines; i++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            map[e1][e2] = 1;
            map[e2][e1] = 1;
        }

        counts = new int[nodes+1];
        bfs(start, end);

        System.out.println(counts[end] == 0 ? -1 : counts[end]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(node == end) break;

            for(int i=1; i<=nodes; i++) {
                if(map[node][i] == 1 && counts[i] == 0) {
                    counts[i] = counts[node]+1;
                    queue.add(i);
                }
            }
        }
    }
}