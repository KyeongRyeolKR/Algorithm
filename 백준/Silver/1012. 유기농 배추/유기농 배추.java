import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int result, T, row, col, cabbage;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int i=0; i<T; i++) {
            result = 0;

            row = sc.nextInt();
            col = sc.nextInt();
            cabbage = sc.nextInt();

            visited = new boolean[row][col];
            map = new int[row][col];

            for(int j=0; j<cabbage; j++) {
                map[sc.nextInt()][sc.nextInt()] = 1;
            }

            for(int j=0; j<row; j++) {
                for(int k=0; k<col; k++) {
                    if(map[j][k] == 1 && !visited[j][k]) {
                        bfs(j, k);
                    }
                }
            }
            System.out.println(result);
        }

    }

    private static void bfs(int startX, int startY) {
        result++;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY});

        while(!queue.isEmpty()) {
            int[] points = queue.poll();
            int x = points[0];
            int y = points[1];

            if(visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for(int i=0; i<4; i++) {
                int movedX = x + dx[i];
                int movedY = y + dy[i];

                if(movedX >= 0 && movedY >= 0 && movedX < row && movedY < col) {
                    if(map[movedX][movedY] == 1) {
                        queue.add(new int[]{movedX, movedY});
                    }
                }
            }
        }
    }
}