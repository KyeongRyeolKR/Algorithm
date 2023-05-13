import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        return compareTo(arr1, arr2);
    }

    public static int compareTo(int[] e1, int[] e2) {
        if(e1.length < e2.length) return -1;
        else if(e1.length > e2.length) return 1;
        else {
            int sum1 = Arrays.stream(e1).sum();
            int sum2 = Arrays.stream(e2).sum();
            return Integer.compare(sum1, sum2);
        }
    }
}