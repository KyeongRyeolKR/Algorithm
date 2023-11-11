import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; // 총 작업 횟수

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long total = 0; // 두 큐의 모든 원소의 합
        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            total += queue1[i] + queue2[i];
        }

        /*
        만약 두 큐의 모든 원소의 합이 홀수라면,
        목표 값을 만들 수 없으므로 -1 반환 후 종료
         */
        if(total % 2 != 0) {
            return -1;
        }

        long target = total / 2; // 목표 값

        long q1Sum = q1.stream().mapToLong(Integer::intValue).sum(); // 현재 첫번째 큐 원소의 합


        while(true) {
            /*
            총 작업 횟수가 일정 횟수(대략, 두 큐의 크기를 합친 숫자 * 2)보다 크다면,
            아무리 반복해도 목표 값을 만들 수 없으므로 -1 반환 후 종료
             */
            if(answer > (q1.size() + q2.size()) * 2) {
                return -1;
            }

            /*
            1. 만약 현재 첫번째 큐 원소의 합이 목표 값보다 크다면,
               첫번째 큐 원소 한개를 두번째 큐로 옮김
               또한 옮기는 원소의 크기 만큼 현재 첫번째 큐 원소의 합을 줄임
               (총 작업 횟수 + 1)

            2. 만약 현재 첫번째 큐 원소의 합이 목표 값보다 작다면,
               두번째 큐 원소 한개를 첫번째 큐로 옮김
               또한 옮기는 원소의 크기 만큼 현재 첫번째 큐 원소의 합을 늘림
               (총 작업 횟수 + 1)

            3. 현재 첫번째 큐 원소의 합이 목표 값과 같다면,
               목표 값을 찾았으므로 while문 종료
             */
            if(q1Sum > target) {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            } else if(q1Sum < target) {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            } else {
                break;
            }

            answer++;
        }

        return answer;
    }
}