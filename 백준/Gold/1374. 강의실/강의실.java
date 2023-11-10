import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Lecture> lectures = new ArrayList<>();
        for(int i=0; i<n; i++) {
            lectures.add(new Lecture(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(lectures);

        int answer = 1;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            while(!q.isEmpty() && q.peek() <= lectures.get(i).start){
                q.poll();
            }
            q.offer(lectures.get(i).end);
            answer = Math.max(answer, q.size());
        }


        System.out.println(answer);
    }

    static class Lecture implements Comparable<Lecture> {
        int no;
        int start;
        int end;

        public Lecture(int no, int start, int end) {
            this.no = no;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "no=" + no +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}