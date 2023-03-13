import java.util.Arrays;

class Solution {
    public static int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            answer = Math.abs(array[i] - n) >= Math.abs(array[answer] - n) ? answer : i;
        }
        return array[answer];
    }
}