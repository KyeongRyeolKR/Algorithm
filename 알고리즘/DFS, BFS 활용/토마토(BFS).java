import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 토마토(BFS)
 * n * m 크기의 토마토 상자가 있다.
 * 익지 않은 토마토는 0, 익은 토마토는 1, 존재하지 않는 칸은 -1로 표시한다.
 * 하루마다 익은 토마토와 인접한 토마토(상하좌우)는 익게 된다.
 * 모든 토마토가 익기 위해서 며칠이 걸리는지 구하라.
 * 단, 모든 토마토가 익지 않는 경우에는 -1을 출력
 */
public class Main {

    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] distance;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        distance = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    q.offer(new Point(i, j));
                }
            }
        }

        bfs();

        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    answer = Math.max(answer, distance[i][j]);
                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Point current = q.poll();
            for(int i=0; i<4; i++) {
                int cr = current.row + dr[i];
                int cc = current.col + dc[i];
                if(cr >= 0 && cr < n && cc >= 0 && cc < m) {
                    if(map[cr][cc] == 0) {
                        map[cr][cc] = 1;
                        q.offer(new Point(cr, cc));
                        distance[cr][cc] = distance[current.col][current.row] + 1;
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