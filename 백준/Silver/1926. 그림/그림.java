import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 아이디어
 * - 2중 for문 => 값 1 && 방문 X => BFS
 *
 * 2. 시간복잡도
 * - BFS => O(V+E)
 * - V = m * n
 * - E = V * 4
 * - V+E = V + 4V = 5V = 5 * m * n = 5 * 500 * 500 = 5 * 250000 = 1250000
 * => 125만 => 해결 가능!
 *
 * 3. 자료구조
 * - 그래프 전체 지도 : int[][]
 * - 방문 여부 : boolean[][]
 * - BFS : Queue
 */
public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int count, max;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][m];

        count = 0;
        max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    max = Math.max(max, bfs(new Point(i, j)));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(Point point) {
        int size = 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i=0; i<4; i++) {
                int cr = current.row + dr[i];
                int cc = current.col + dc[i];
                if(cr >= 0 && cc >= 0 && cr < n && cc < m) {
                    if(map[cr][cc] == 1 && !visited[cr][cc]) {
                        size++;
                        visited[cr][cc] = true;
                        queue.add(new Point(cr, cc));
                    }
                }
            }
        }

        return size;
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}