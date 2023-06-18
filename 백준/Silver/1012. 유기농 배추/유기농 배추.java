import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int width, height, count, answer;

//                    상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            width = sc.nextInt();
            height = sc.nextInt();
            count = sc.nextInt();
            answer = 0;

            map = new int[height][width];
            for(int j=0; j<count; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            visited = new boolean[height][width];

            for(int j=0; j<height; j++) {
                for(int k=0; k<width; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void bfs(int row, int col) {
        answer++;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];

            if(visited[r][c]) continue;

            visited[r][c] = true;

            for(int i=0; i<4; i++) {
                int cr = dr[i] + r;
                int cc = dc[i] + c;

                if(cr >= 0 && cc >= 0 && cr < height && cc < width) {
                    if(map[cr][cc] == 1) {
                        queue.add(new int[]{cr, cc});
                    }
                }
            }
        }
    }
}