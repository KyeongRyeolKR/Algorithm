import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로의 최단 거리 통로(BFS)
 * 7 * 7 격자판 미로를 탈출하는 최단 경로의 길이를 구하라
 * 출발점 (1,1)
 * 도착점 (7,7)
 * 격자판의 1은 벽이고, 0은 통로이다.
 * 상하좌우로만 이동할 수 있다.
 */
public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[][] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[8][8];
        distance = new int[8][8];
        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(1, 1);

        int end = distance[7][7];
        if(end == 0) {
            System.out.println(-1);
        } else {
            System.out.println(end);
        }
    }

    public static void bfs(int row, int col) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row ,col));
        map[col][row] = 1;

        while(!q.isEmpty()) {
            Point current = q.poll();
            for(int i=0; i<4; i++) {
                int cr = current.row + dr[i];
                int cc = current.col + dc[i];
                if(cr >= 1 && cr <= 7 && cc >= 1 && cc <= 7) {
                    if(map[cr][cc] == 0) {
                        map[cr][cc] = 1;
                        q.offer(new Point(cr, cc));
                        distance[cr][cc] = distance[current.row][current.col] + 1;
                    }
                }
            }
        }
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