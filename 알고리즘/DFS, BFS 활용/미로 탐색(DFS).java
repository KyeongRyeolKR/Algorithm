import java.util.Scanner;

/**
 * 미로 탐색(DFS)
 * 7 * 7 격자판 미로를 탈출하는 경로의 가지 수를 구하라
 * 출발점 (1,1)
 * 도착점 (7,7)
 * 격자판의 1은 벽이고, 0은 통로이다.
 * 상하좌우로만 이동할 수 있다.
 */
public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[8][8];
        for(int i=1; i<=7; i++) {
            for(int j=1; j<=7; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        map[1][1] = 1;

        dfs(1, 1);

        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        if(row == 7 && col == 7) {
            answer++;
        } else {
            for(int i=0; i<4; i++) {
                int cr = row + dr[i];
                int cc = col + dc[i];
                if(cr >= 1 && cr <= 7 && cc >=1 && cc <= 7) {
                    if(map[cr][cc] == 0) {
                        map[cr][cc] = 1;
                        dfs(cr, cc);
                        map[cr][cc] = 0;
                    }
                }
            }
        }
    }
}