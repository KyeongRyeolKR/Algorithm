import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int pri : priorities) {
            pq.offer(pri);
        }

        System.out.println(pq);

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;

                    if (location == i) {
                        pq.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }
}