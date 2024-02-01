import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] order;
    static Map<Integer, Set<Integer>> prefer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];
        order = new int[n*n];

        prefer = new HashMap<>();
        for(int i=0; i<n*n; i++) {
            int num = sc.nextInt();
            order[i] = num;
            prefer.put(num, new HashSet<>());
            for(int j=0; j<4; j++) {
                prefer.get(num).add(sc.nextInt());
            }
        }

        for(int i=0; i<order.length; i++) {
            Seat seat = findSeat(order[i]);
            map[seat.row][seat.col] = order[i];
        }

        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int likeCount = getLikeCount(i, j, map[i][j]);
                if(likeCount > 0) {
                    sum += (int) Math.pow(10, likeCount - 1);
                }
            }
        }

        System.out.println(sum);
    }

    private static Seat findSeat(int num) {
        Seat seat = null;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] > 0) {
                    continue;
                }

                Seat current = new Seat(i, j, getLikeCount(i, j, num), getEmptyCount(i, j));
                if(seat == null) {
                    seat = current;
                    continue;
                }

                if(seat.compareTo(current) > 0) {
                    seat = current;
                }
            }
        }
        
        return seat;
    }

    private static int getEmptyCount(int row, int col) {
        int count = 0;
        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];
            if(cr >= 0 && cc >= 0 && cr < n && cc < n) {
                if(map[cr][cc] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int getLikeCount(int row, int col, int num) {
        int count = 0;
        for(int i=0; i<4; i++) {
            int cr = row + dr[i];
            int cc = col + dc[i];
            if(cr >= 0 && cc >= 0 && cr < n && cc < n) {
                if(prefer.get(num).contains(map[cr][cc])) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Seat implements Comparable<Seat> {
    int row;
    int col;
    int likeCount;
    int emptyCount;

    public Seat(int row, int col, int likeCount, int emptyCount) {
        this.row = row;
        this.col = col;
        this.likeCount = likeCount;
        this.emptyCount = emptyCount;
    }

    @Override
    public int compareTo(Seat o) {
        if(likeCount != o.likeCount) {
            return -(likeCount - o.likeCount);
        }

        if(emptyCount != o.emptyCount) {
            return -(emptyCount - o.emptyCount);
        }

        if(row != o.row) {
            return row - o.row;
        }

        return col - o.col;
    }
}