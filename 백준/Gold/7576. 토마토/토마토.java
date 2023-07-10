import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        System.out.println(max - 1);

        br.close();
    }


    private static void bfs() {
        while(!q.isEmpty()) {
            int[] point = q.poll();

            for(int i=0; i<4; i++) {
                int cr = point[0] + dr[i];
                int cc = point[1] + dc[i];

                if(cr >= 0 && cr < R && cc >= 0 && cc < C) {
                    if(!visited[cr][cc] && map[cr][cc] == 0) {
                        map[cr][cc] = map[point[0]][point[1]] + 1;
                        q.add(new int[]{cr, cc});
                    }
                }
            }
        }
    }
}