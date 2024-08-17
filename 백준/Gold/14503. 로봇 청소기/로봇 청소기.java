import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int direction;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count = 1;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sc = Integer.parseInt(st.nextToken());
        int sr = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(sc, sr);

        System.out.println(count);
    }

    private static void dfs(int row, int col) {
        map[row][col] = -1;

        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4;
            int cr = dr[direction] + row;
            int cc = dc[direction] + col;
            if(cr >= 0 && cc >= 0 && cr < n && cc < m) {
                if(map[cr][cc] == 0) {
                    count++;
                    dfs(cr, cc);
                    return;
                }
            }
        }

        int back = (direction + 2) % 4;
        int br = dr[back] + row;
        int bc = dc[back] + col;
        if(br >= 0 && bc >= 0 && br < n && bc < m) {
            if(map[br][bc] != 1) {
                dfs(br, bc);
            }
        }
    }
}