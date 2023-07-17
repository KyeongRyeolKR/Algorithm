import java.util.Scanner;

public class Main {

    static int N, M, K, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }

//        for(int i=1; i<=N; i++) {
//            for(int j=1; j<=M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = -1;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    if(count > max) {
                        max = count;
                    }
                    count = 0;
                }
            }
        }

        System.out.println(max);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        count++;

        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            if(cr >= 1 && cr <= N && cc >= 1 && cc <= M) {
                if(!visited[cr][cc] && map[cr][cc] == 1) {
                    dfs(cr, cc);
                }
            }
        }
    }
}