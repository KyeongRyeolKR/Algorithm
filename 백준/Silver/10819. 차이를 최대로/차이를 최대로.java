import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static int result;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        answer = new int[n];
        visited = new boolean[n];
        
        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int count) {
        if(count == n) {
            int sum = 0;
            for(int i=0; i<n-1; i++) {
                sum += Math.abs(answer[i] - answer[i+1]);
            }

            result = Math.max(result, sum);

            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer[count] = arr[i];
                visited[i] = true;
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
}