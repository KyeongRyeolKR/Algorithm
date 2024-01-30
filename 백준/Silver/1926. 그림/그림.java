import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int row, col;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int count, max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        visited = new boolean[row][col];
        map = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static void bfs(int sRow, int sCol) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sRow, sCol));
        visited[sRow][sCol] = true;

        int size = 0;
        while(!q.isEmpty()) {
            size++;
            Point current = q.poll();
            int nr = current.row;
            int nc = current.col;
            for(int i=0; i<4; i++) {
                int cr = dr[i] + nr;
                int cc = dc[i] + nc;
                if(cr >= 0 && cc >= 0 && cr < row && cc < col) {
                    if(!visited[cr][cc] && map[cr][cc] == 1) {
                        q.add(new Point(cr, cc));
                        map[cr][cc] = map[nr][nc] + 1;
                        visited[cr][cc] = true;
                    }
                }
            }
        }
        max = Math.max(size, max);
    }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}