import java.util.*;

/**
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * 4	[4,4,4,4,4]	[4,1,2,3]
 */
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        for (int stage = 1; stage <= N; stage++) {
            int fail = 0;
            int comeToStage = 0;
            for (int i = 0; i < stages.length; i++) {
                if (stage == stages[i]) fail++;
                if (stage <= stages[i]) comeToStage++;
            }
            if(comeToStage == 0) {
                map.put(stage, 0.0);
            } else {
                map.put(stage, ((double) fail / comeToStage));
            }
        }

        System.out.println(map);

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int[] answer = new int[N];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[]{2,1,2,6,2,4,3,3});
        new Solution().solution(4, new int[]{4,4,4,4,4});
        new Solution().solution(5, new int[]{4,4,4,4,4});
    }
}