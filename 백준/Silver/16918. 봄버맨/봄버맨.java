import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int r;
    static int c;
    static int n;
    static String[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        for(int i=2; i<=n; i++) {
            if(i % 2 == 1) {
                for(int j=0; j<r; j++) {
                    for(int k=0; k<c; k++) {
                        if(map[j][k].equals("O")) {
                            queue.add(new Point(j, k));
                        }
                    }
                }

                all();

                bfs();
            }
        }

        if(n % 2 == 0) {
            all();
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void all() {
        for (String[] arr : map) {
            Arrays.fill(arr, "O");
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.row;
            int col = p.col;
            map[row][col] = ".";
            for (int i = 0; i < 4; i++) {
                int cr = row + dr[i];
                int cc = col + dc[i];
                if (cr >= 0 && cr < r && cc >= 0 && cc < c) {
                    if (map[cr][cc].equals("O")) {
                        map[cr][cc] = ".";
                    }
                }
            }
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}