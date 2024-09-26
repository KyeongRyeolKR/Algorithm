import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dr = {0, 0, 1, -1 ,1 ,1 ,- 1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, -1, 1};
    static int result = 0;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    continue;
                }

                int tempResult = bfs(i, j);

                result = Math.max(tempResult, result);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
    private static int bfs(int row, int col) {
        visited = new boolean[n][m];
        visited[row][col] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 8; i++) {
                int cr = poll.row + dr[i];
                int cc = poll.col + dc[i];
                int cd = poll.distance + 1;

                if (cr < 0 || cc < 0 || cr >= n || cc >= m || visited[cr][cc]) {
                    continue;
                }

                if (map[cr][cc] == 1) {
                    return cd;
                }

                queue.offer(new Point(cr, cc, cd));
                visited[cr][cc] = true;
            }
        }

        return 0;
    }
}

class Point {
    int row;
    int col;
    int distance;

    public Point(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.distance = dist;
    }
}