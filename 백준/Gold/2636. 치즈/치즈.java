import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] board;
    static int n, m;
    static int cheese;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        cheese = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int cheeseCount = 0;
        int time = 0;
        while(cheese != 0) {
            cheeseCount = cheese;
            time++;
            visited = new boolean[n][m];
            
            bfs();
        }
        
        System.out.println(time);
        System.out.println(cheeseCount);
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            for(int i = 0; i < 4; i++) {
                int cr = current[0] + dr[i];
                int cc = current[1] + dc[i];

                if(cr >= 0 && cc >= 0 && cr < n && cc < m && visited[cr][cc] == false) {
                    visited[cr][cc] = true;
                    if(board[cr][cc] == 0) {
                        q.offer(new int[]{cr, cc});
                    } else {
                        cheese--;
                        board[cr][cc] = 0;
                    }
                }
            }
        }
    }
}    
 