import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        answer = new int[n][m];

        int startX = -1;
        int startY = -1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int input = sc.nextInt();
                if(input == 2) {
                    startX = i;
                    startY = j;
                } else if(input == 0) {
                    visited[i][j] = true;
                }
                map[i][j] = input;
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j]) {
                    answer[i][j] = -1;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] point = q.poll();
            for(int i=0; i<4; i++) {
                int cx = dx[i] + point[0];
                int cy = dy[i] + point[1];
                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (!visited[cx][cy] && map[cx][cy] == 1) {
                        visited[cx][cy] = true;
                        answer[cx][cy] = answer[point[0]][point[1]] + 1;
                        q.offer(new int[]{cx, cy});
                    }
                }
            }
        }
    }
}