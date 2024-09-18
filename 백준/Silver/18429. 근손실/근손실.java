import java.util.Scanner;

public class Main {

    static final int MY_WEIGHT = 500;
    static int n;
    static int k;
    static int answer = 0;
    static int[] kits;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        kits = new int[n];
        for(int i=0; i<n; i++) {
            kits[i] = sc.nextInt();
        }

        visited = new boolean[n];

        dfs(0, MY_WEIGHT);

        System.out.println(answer);
    }

    private static void dfs(int count, int currentWeight) {
        if(count == n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            int result = currentWeight + kits[i] - k;
            if(!visited[i] && result >= MY_WEIGHT) {
                visited[i] = true;
                dfs(count + 1, result);
                visited[i] = false;
            }
        }
    }
}