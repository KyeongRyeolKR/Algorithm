import java.util.*;

public class Main {

    static int R, C, answer;
    static int[][] map;
    static boolean[] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        map = new int[R+1][C+1];
        visited = new boolean[26];

        for(int i=1; i<=R; i++) {
            String temp = sc.nextLine();
            for(int j=1; j<=C; j++) {
                map[i][j] = temp.charAt(j-1) - 'A';
            }
        }

//        for(int i=1; i<=R; i++) {
//            for(int j=1; j<=C; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        dfs(1, 1, 1);
        System.out.println(answer);
    }

    private static void dfs(int row, int col, int count) {
        visited[map[row][col]] = true;
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            if (cr >= 1 && cr <= R && cc >= 1 && cc <= C) {
                if(!visited[map[cr][cc]]) {
                    dfs(cr, cc, count+1);
                    visited[map[cr][cc]] = false;
                }
            }
        }
    }
}