import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        Arrays.stream(arr)
                .forEach(i -> IntStream.range(0, i)
                        .mapToObj(j -> i)
                        .forEach(list::add)
                );

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{5,1,4});
    }
}