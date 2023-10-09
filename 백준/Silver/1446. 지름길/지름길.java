import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, d;
    static List<Shortcut> shortcuts;
    static boolean[] check;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        d = sc.nextInt();

        shortcuts = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int distance = sc.nextInt();

            if(start > d || end > d){
                continue;
            }

            shortcuts.add(new Shortcut(start, end, distance));
        }

        check = new boolean[shortcuts.size()];

        dfs(0, d, 0);

        System.out.println(result);
    }

    private static void dfs(int now, int end, int distance) {
        if(now > end) {
            return;
        } else if(now == end) {
            result = Math.min(result, distance);
            return;
        } else {
            result = Math.min(result, distance + end - now);
        }

        for(int i=0; i<shortcuts.size(); i++) {
            if(!check[i]) {
                Shortcut s = shortcuts.get(i);
                if(s.start == now) {
                    check[i] = true;
                    dfs(s.end, d, distance + s.distance);
                    check[i] = false;
                }
            }
        }

        dfs(now + 1, d, distance + 1);
    }
}

class Shortcut {
    int start;
    int end;
    int distance;

    public Shortcut(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}