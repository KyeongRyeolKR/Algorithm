import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 섬나라 아일랜드(BFS)
 * n * n 크기 격자판에 섬이 표시되어 있다.
 * 섬은 1, 아닌 것은 0
 * 섬은 상하좌우 대각선까지 연결되어 있다.
 * 총 몇개의 섬이 있는지 구하라.
 */
public class Main {

    static int n;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    answer++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col));

        while(!q.isEmpty()) {
            Point current = q.poll();
            for(int i=0; i<8; i++) {
                int cr = current.row + dr[i];
                int cc = current.col + dc[i];
                if(cr >= 0 && cr < n && cc >= 0 && cc < n) {
                    if(map[cr][cc] == 1 && !visited[cr][cc]) {
                        visited[cr][cc] = true;
                        q.offer(new Point(cr, cc));
                    }
                }
            }
        }
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