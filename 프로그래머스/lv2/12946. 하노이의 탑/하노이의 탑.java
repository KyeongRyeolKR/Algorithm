import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<int[]> paths = new ArrayList<>();

    public int[][] solution(int n) {
        dfs(1,3,n);
        return paths.toArray(int[][]::new);
    }

    private static void dfs(int from, int to, int n) {
        if(n == 1) {
            paths.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        dfs(from, empty, n - 1);
        dfs(from, to, 1);
        dfs(empty, to, n - 1);
    }
}
