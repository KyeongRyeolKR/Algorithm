import java.util.*;

public class Main {

    static int size;
    static int[][] map;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int t=0; t<n; t++) {
            size = sc.nextInt();
            map = new int[size][size];

            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());

            bfs(start);

            if(start.equals(end)) {
                System.out.println(0);
            } else {
                System.out.println(map[end.row][end.col]);
            }
        }
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int cr = now.row + dr[i];
                int cc = now.col + dc[i];
                if(cr >= 0 && cc >= 0 && cr < size && cc < size) {
                    Point next = new Point(cr, cc);
                    if(map[next.row][next.col] > 0) continue;
                    queue.add(next);
                    map[next.row][next.col] = map[now.row][now.col] + 1;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}