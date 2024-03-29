import java.util.*;

public class Solution {
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<scoville.length; i++) {
			pq.add(scoville[i]);
		}
		
		int answer = 0;
		while(pq.peek() < K) {
			if (pq.size() == 1) {
                return -1;
		    }
			
			int first = pq.poll();
            int second = pq.poll();
            
            int result = first + (second * 2);
            pq.add(result);
            
            answer++;
		}
        
		return answer;
	}
}