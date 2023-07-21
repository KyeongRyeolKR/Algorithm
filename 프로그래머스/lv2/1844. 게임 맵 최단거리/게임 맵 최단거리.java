import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] distance;

    public int solution(int[][] maps) {
        distance = new int[maps.length][maps[0].length];

        bfs(new Point(0, 0), maps);

        // for(int i=0; i<distance.length; i++) {
        //     for(int j=0; j<distance[i].length; j++) {
        //         System.out.print(distance[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        if (distance[distance.length-1][distance[0].length-1] == 0) {
            return -1;
        }

        return distance[distance.length-1][distance[0].length-1];
    }

    private void bfs(Point s, int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        distance[s.row][s.col] = 1;
        q.add(s);

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i=0; i<4; i++) {
                int cr = p.row + dr[i];
                int cc = p.col + dc[i];

                if(cr >= 0 && cr < maps.length && cc >= 0 && cc < maps[0].length) {
                    if(distance[cr][cc] == 0 && maps[cr][cc] == 1) {
                        q.add(new Point(cr, cc));
                        distance[cr][cc] = distance[p.row][p.col] + 1;
                    }
                }
            }
        }
    }

    // public static void main(String[] args) {
    //     System.out.println(
    //             new Solution().solution(
    //                     new int[][]{
    //                             {1,0,1,1,1},
    //                             {1,0,1,0,1},
    //                             {1,0,1,1,1},
    //                             {1,1,1,0,1},
    //                             {0,0,0,0,1}}
    //             )
    //     );
    // }
}

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}