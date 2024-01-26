import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Arrays.sort(lines, (o1, o2) -> {
            if(o1.start == o2.start) {
                return (int) (o1.end - o2.end);
            }
            return (int) (o1.start - o2.start);
        });

        long startPoint = lines[0].start;
        long endPoint = lines[0].end;
        long total = endPoint - startPoint;
        for(int i=1; i<lines.length; i++) {
            if(startPoint <= lines[i].start && endPoint >= lines[i].end) {
                continue;
            } else if(lines[i].start < endPoint) {
                total += lines[i].end - endPoint;
            } else {
                total += lines[i].end - lines[i].start;
            }

            startPoint = lines[i].start;
            endPoint = lines[i].end;
        }

        System.out.println(total);
    }
}

class Line {
    long start;
    long end;

    public Line(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }
}