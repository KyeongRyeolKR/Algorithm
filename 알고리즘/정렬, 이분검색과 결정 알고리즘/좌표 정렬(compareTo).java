import java.util.*;

/**
 * 좌표 정렬
 * N개의 평면상의 좌표 (x,y)가 주어지면 모든 좌표를 오름차순으로 정렬하라.
 * 조건 : x값을 기준으로 정렬하되, x값이 같을 경우 y값을 기준으로 정렬하라.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 포인트 수

        List<Point> points = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        Collections.sort(points); // Point 객체에 compareTo() 메소드를 기준으로 정렬함

        for(Point p : points) {
            System.out.println(p.x + " " + p.y);
        }
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // x값이 같을 경우, y값을 기준으로 오름차순
            if(this.x == o.x) {
                return this.y - o.y;
            }
            // 기본 : x값을 기준으로 오름차순
            return this.x - o.x;
        }
    }
}