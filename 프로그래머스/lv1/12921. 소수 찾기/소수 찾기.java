import java.util.Arrays;

class Solution {
    public int solution(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, 2, n+1, true);

        for(int i=2; i<Math.sqrt(n); i++) {
            if(arr[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    arr[j] = false;
                }
            }
        }
        
        int count = 0;
        for (boolean b : arr) {
            if (b) count++;
        }

        return count;
    }
}