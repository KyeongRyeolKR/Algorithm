import java.util.*;

public class Main {

    static int R, C;
    static String[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> flood = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        map = new String[R][C];
        distance = new int[R][C];
        visited = new boolean[R][C];

        Point start = new Point();
        Point end = new Point();
        Point startFlood = new Point();

        for(int i=0; i<R; i++) {
            String temp = sc.nextLine();
            for(int j=0; j<C; j++) {
                map[i][j] = String.valueOf(temp.charAt(j));
                if(map[i][j].equals("S")) {
                    start = new Point(i, j);
                }
                if(map[i][j].equals("D")) {
                    end = new Point(i, j);
                }
                if(map[i][j].equals("*")) {
                    startFlood = new Point(i, j);
                    flood.add(startFlood);
                    visited[startFlood.row][startFlood.col] = true;
                }
            }
        }

        bfs(start, end);

//        for(int i=0; i<R; i++) {
//            for(int j=0; j<C; j++) {
//                System.out.print(distance[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(distance[end.row][end.col] == 0) {
            System.out.println("KAKTUS");
            return;
        }

        System.out.println(distance[end.row][end.col]);
    }

    private static void bfs(Point startMe, Point end) {
        Queue<Point> me = new LinkedList<>();
        me.add(startMe);
        visited[startMe.row][startMe.col] = true;

        while(!me.isEmpty() && !visited[end.row][end.col]) {
            int wSize = flood.size();
            for(int i=0; i<wSize; i++) {
                Point water = flood.poll();

                for (int j = 0; j < 4; j++) {
                    int cr = water.row + dr[j];
                    int cc = water.col + dc[j];

                    if (cr >= 0 && cr < R && cc >= 0 && cc < C) {
                        if (!visited[cr][cc] && !map[cr][cc].equals("X") && !map[cr][cc].equals("D")) {
                            flood.add(new Point(cr, cc));
                            visited[cr][cc] = true;
                        }
                    }
                }
            }

            int mSize = me.size();
            for(int i=0; i<mSize; i++) {
                Point now = me.poll();

                for (int j = 0; j < 4; j++) {
                    int cr = now.row + dr[j];
                    int cc = now.col + dc[j];

                    if (cr >= 0 && cr < R && cc >= 0 && cc < C) {
                        if (!visited[cr][cc] && !map[cr][cc].equals("X")) {
                            me.add(new Point(cr, cc));
                            visited[cr][cc] = true;
                            distance[cr][cc] = distance[now.row][now.col] + 1;
                        }
                    }
                }
            }
        }
    }
}

class Point {
    int row;
    int col;

    public Point() {}

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}