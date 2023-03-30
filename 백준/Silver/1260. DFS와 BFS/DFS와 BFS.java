import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static boolean[] visited;
    static int[][] arr;
    static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pointCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int start = sc.nextInt();

        arr = new int[pointCount+1][pointCount+1];
        visited = new boolean[pointCount+1];
        queue = new LinkedList<>();

        for(int i=0; i<lineCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(start);
        System.out.println();

        visited = new boolean[pointCount+1];

        bfs(start);
    }

    private static void dfs(int start) {
        visited[start] = true;

        System.out.print(start + " ");

        for(int i=1; i<arr[start].length; i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        queue.offer(start);

        visited[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();

            System.out.print(start + " ");

            for(int i=1; i<arr[start].length; i++) {
                if(arr[start][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}