import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(String A, String B) {
        String[] A_ = A.split("");
        Deque<String> queue = new ArrayDeque<>(List.of(A_));

        int count = 0;
        for(int i=0; i<A.length(); i++) {

            String temp = String.join("", queue);

            if(temp.equals(B)) return count;

            queue.offerFirst(queue.pollLast());

            count++;
        }

        return -1;
    }
}