import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        list = new List[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n+1];
        distance = new int[n+1];
        bfs(1);

        int max = Arrays.stream(distance).max().getAsInt();
        int num = IntStream.rangeClosed(1, distance.length).filter(i -> distance[i] == max).findFirst().getAsInt();
        int cnt = (int) Arrays.stream(distance).filter(e -> e == max).count();

        System.out.println(num + " " + max + " " + cnt);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int current = q.poll();
            for(int next : list[current]) {
                if(!visited[next]) {
                    q.add(next);
                    distance[next] = distance[current] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}