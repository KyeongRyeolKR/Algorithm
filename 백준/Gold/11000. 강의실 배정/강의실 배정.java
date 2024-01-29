import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] arr = new Lecture[n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = new Lecture(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(arr);

        Queue<Integer> q = new PriorityQueue<>();
        int endTime = 0;
        for(Lecture m : arr) {
            endTime = m.end;

            if(!q.isEmpty() && q.peek() <= m.start) {
                q.poll();
            }
            q.add(endTime);
        }

        System.out.println(q.size());
    }
}

class Lecture implements Comparable<Lecture> {
    int start;
    int end;

    public Lecture(int start, int end) {
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
}