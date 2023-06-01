import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int[] temp = arr.clone();
            temp[query[0]] = arr[query[1]];
            temp[query[1]] = arr[query[0]];
            arr = temp;
        }

        return arr;
    }
}