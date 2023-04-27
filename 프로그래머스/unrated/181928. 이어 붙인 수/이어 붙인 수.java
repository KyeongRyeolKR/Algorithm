import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        IntStream.range(0, num_list.length).forEach(i -> {
            if (num_list[i] % 2 == 0) a.append(num_list[i]);
            else b.append(num_list[i]);
        });
        
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
    }
}