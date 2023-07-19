import java.util.*;

public class Main {

    static int R, C, max;
    static boolean isCycle;
    static String[][] map;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new String[R][C];
        dp = new int[R][C];
        visited = new boolean[R][C];
        sc.nextLine();
        for(int i=0; i<R; i++) {
            String temp = sc.nextLine();
            for(int j=0; j<C; j++) {
                map[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        dfs(0, 0, 1);

        if(isCycle) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    private static void dfs(int row, int col, int count) {
        dp[row][col] = count;
        if(count > max) {
            max = count;
        }

        for(int i=0; i<4; i++) {
            int cr = row;
            int cc = col;

            if(i == 0) {
                cr = cr - Integer.parseInt(map[row][col]);
            } else if(i == 1) {
                cr = cr + Integer.parseInt(map[row][col]);
            } else if(i == 2) {
                cc = cc - Integer.parseInt(map[row][col]);
            } else {
                cc = cc + Integer.parseInt(map[row][col]);
            }

            if(cr < 0 || cr >= R || cc < 0 || cc >= C) {
                continue;
            }

            if(map[cr][cc].equals("H")) {
                continue;
            }

            if(count < dp[cr][cc]) {
                continue;
            }

            if(visited[cr][cc]) {
                isCycle = true;
                return;
            }

            visited[cr][cc] = true;
            dfs(cr, cc, count+1);
            visited[cr][cc] = false;
        }
    }
}