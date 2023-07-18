import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List<Integer> list;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        num = new int[N+1];
        for(int i=1; i<=N; i++) {
            num[i] = sc.nextInt();
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int x : list) {
            System.out.println(x);
        }
    }

    private static void dfs(int start, int target) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }

        if(num[start] == target) {
            list.add(target);
        }
    }
}