import java.util.*;
import java.io.*;

public class Main {
    static int n, m, h;
    static int[][][] data;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        data = new int[h][n][m];

        int result = 0;
        for (int k=0; k<h; k++) {
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<m; j++) {
                    data[k][i][j] = Integer.parseInt(st.nextToken());
                    if (data[k][i][j] == 1) {
                        int[] push = {k, i, j};
                        q.add(push);
                    }
                }
            }
        }

        bfs();
        
        for (int k=0; k<h; k++) {
            for (int i=0; i<n; i++) {
                int max_value = 0;
                for (int j=0; j<m; j++) {
                    if (data[k][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    max_value = Math.max(max_value, data[k][i][j]);
                }

                result = Math.max(result, max_value);
            }
        }

        System.out.println(result - 1);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] pop = q.remove();
            int z = pop[0];
            int x = pop[1];
            int y = pop[2];
            for (int d=0; d<6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 <= nz && nz < h && 0 <= nx && nx < n && 0 <= ny && ny < m && data[nz][nx][ny] == 0) {
                    data[nz][nx][ny] = data[z][x][y] + 1;
                    int[] push = {nz, nx, ny};
                    q.add(push);
                }
            }
        }
    }
}