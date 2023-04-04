import java.util.*;

class Main {
    static int[][] arr;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];
        arr = new int[n+1][n+1];

        for(int i=1; i<=m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for(int i=1; i<arr[start].length; i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}