import java.util.Scanner;

public class Main {

    static int N, count;
    static String[][] map;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        visited = new int[N][N];
        map = new String[N][N];
        for(int i=0; i<N; i++) {
            String[] temp = sc.nextLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = temp[j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] == 0) {
                    count++;
                    dfs(i, j, false);
                }
            }
        }
        System.out.println(count);

        count = 0;
        visited = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j] == 0) {
                    count++;
                    dfs(i, j, true);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int row, int col, boolean isBlindness) {
        visited[row][col] = count;

        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            if(cr >= 0 && cr < N && cc >= 0 && cc < N) {
                if(!isBlindness && visited[cr][cc] == 0 && map[cr][cc].equals(map[row][col])) {
                    dfs(cr, cc, isBlindness);
                }

                if(isBlindness && visited[cr][cc] == 0) {
                    if(map[row][col].equals("R") || map[row][col].equals("G")) {
                        if(map[cr][cc].equals("R") || map[cr][cc].equals("G")) {
                            dfs(cr, cc, isBlindness);
                        }
                    }
                    if(map[row][col].equals("B") && map[cr][cc].equals("B")) {
                        dfs(cr, cc, isBlindness);
                    }
                }
            }
        }
    }
}