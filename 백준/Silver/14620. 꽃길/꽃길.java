import java.util.Scanner;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int count, int sum) {
        if(count == 3) {
            result = Math.min(result, sum);
        } else {
            for(int i=2; i<n; i++) {
                for(int j=2; j<n; j++) {
                    if(canPlant(i, j)) {
                        int currentTotal = sum(i, j);

                        dfs(count+1, sum + currentTotal);

                        rollbackVisited(i, j);
                    }
                }
            }
        }
    }

    /**
     * 백트래킹을 하기 위해 visited 배열을 롤백하는 메서드
     */
    private static void rollbackVisited(int row, int col) {
        // 해당 좌표 방문 롤백
        visited[row][col] = false;

        // 상하좌우 좌표 방문 롤백
        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            visited[cr][cc] = false;
        }
    }

    /**
     * 해당 좌표와 주변 좌표들을 방문 처리하고, 필요한 비용을 계산해주는 메서드
     */
    private static int sum(int row, int col) {
        // 해당 좌표 방문 처리
        visited[row][col] = true;

        // 해당 좌표에 꽃을 심기 위해 필요한 비용을 담는 변수
        int total = map[row][col];

        // 상하좌우 탐색
        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            // 방문 처리 및 필요한 비용 누적
            visited[cr][cc] = true;
            total += map[cr][cc];
        }

        return total;
    }

    /**
     * 해당 좌표에 꽃을 심을 수 있는지 체크하는 메서드
     */
    private static boolean canPlant(int row, int col) {
        // 해당 좌표에 이미 방문을 했으면 false
        if(visited[row][col]) {
            return false;
        }

        // 해당 좌표 상하좌우에 한곳이라도 방문을 했으면 false
        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];

            if(visited[cr][cc]) {
                return false;
            }
        }

        // 모든 조건에 걸리지 않았으면 true
        return true;
    }
}