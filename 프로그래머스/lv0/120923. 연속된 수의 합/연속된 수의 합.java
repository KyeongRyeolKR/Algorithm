import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int num, int total) {
        int mid = 0;
        int plusCount = num / 2;
        List<Integer> list = new ArrayList<>();
        if(num % 2 != 0) {
            mid = total / num;
            list.add(mid);
            for(int i=1; i<=plusCount; i++) {
                list.add(mid-i);
                list.add(mid+i);
            }
        } else {
            int first = (total / num + 1) - (total % num);
            for(int i=0; i<num; i++) {
                list.add(first);
                first++;
            }
        }

        return list.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(6,33)));
    }
}