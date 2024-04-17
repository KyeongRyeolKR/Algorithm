import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static List<Point> chickens = new LinkedList<>();
    static List<Point> houses = new LinkedList<>();
    static boolean[] chickenVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();

                if(map[i][j] == 1) {
                    houses.add(new Point(i, j));
                } else if(map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        chickenVisited = new boolean[chickens.size()];
        
        dfs(0, 0);
        
        System.out.println(min);
    }

    private static void dfs(int start, int count) {
        if(count == m) {
            int total = 0;
            for(int i=0; i<houses.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j=0; j<chickens.size(); j++) {
                    if(chickenVisited[j]) {
                        int distance = Math.abs(houses.get(i).row - chickens.get(j).row) + Math.abs(houses.get(i).col - chickens.get(j).col);
                        sum = Math.min(sum, distance);
                    }
                }

                total += sum;
            }

            min = Math.min(min, total);

            return;
        }

        for(int i=start; i<chickens.size(); i++) {
            if(!chickenVisited[i]) {
                chickenVisited[i] = true;
                dfs(i+1, count+1);
                chickenVisited[i] = false;
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