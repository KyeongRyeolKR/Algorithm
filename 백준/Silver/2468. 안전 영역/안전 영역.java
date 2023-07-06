import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0}; // 시계 방향
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N+1][N+1];
        int maxHeight = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for(int rain=0; rain<=maxHeight; rain++) {
            visited = new boolean[N+1][N+1];
            int area = 0;
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(!visited[i][j] && map[i][j] > rain) {
                        area += dfs(i, j, rain);
                    }
                }
            }
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    private static int dfs(int row, int col, int rain) {
        visited[row][col] = true;

        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];
            if(cr >= 1 && cr <= N && cc >= 1 && cc <= N) {
                if(!visited[cr][cc] && map[cr][cc] > rain) {
                    dfs(cr, cc, rain);
                }
            }
        }

        return 1;
    }
}