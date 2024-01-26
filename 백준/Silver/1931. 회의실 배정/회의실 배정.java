import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for(int i=0; i<n; i++) {
            meetings[i] = new Meeting(sc.nextLong(), sc.nextLong());
        }

        Meeting[] sorted = Arrays.stream(meetings)
                .sorted(Comparator.comparingLong(Meeting::getEnd).thenComparingLong(Meeting::getStart))
                .toArray(Meeting[]::new);

        int count = 1;
        int lastIndex = 0;
        for(int i=1; i<n; i++) {
            if(sorted[i].start >= sorted[lastIndex].end) {
                count++;
                lastIndex = i;
            }
        }

        System.out.println(count);
    }
}

class Meeting {
    long start;
    long end;

    public Meeting(long start, long end) {
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