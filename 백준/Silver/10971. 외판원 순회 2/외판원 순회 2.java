import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            visited[i] = true;
            back(i, i, 0, 0);
        }

        System.out.println(answer);
    }

    private static void back(int start, int now, int sum, int count) {
        if(count == n - 1) {
            if(map[now][start] != 0) {
                sum += map[now][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                back(start, i, sum + map[now][i], count + 1);
                visited[i] = false;
            }
        }
    }
}