import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCounts = new int[number];
        for(int i=0; i<divisorCounts.length; i++) {
            divisorCounts[i] = getDivisorCount(i+1);
            
            if(divisorCounts[i] > limit) {
                divisorCounts[i] = power;
            }
        }

        return Arrays.stream(divisorCounts).sum();
    }

    public int getDivisorCount(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (i * i != num) {
                    count++;
                }
            }
        }

        return count;
    }
}