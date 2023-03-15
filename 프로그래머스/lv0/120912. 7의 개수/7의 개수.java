import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
//        return (int) Arrays.stream(Arrays.stream(array)
//                        .mapToObj(String::valueOf)
//                        .collect(Collectors.joining())
//                        .split(""))
//                .filter(e -> e.equals("7"))
//                .count();

        return (int) Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining())
                .chars()
                .filter(e -> e == '7')
                .count();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7,77,17}));
    }
}