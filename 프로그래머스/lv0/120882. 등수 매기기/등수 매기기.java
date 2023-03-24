import java.util.Arrays;

class Solution {
    public int[] solution(int[][] score) {
        double[] average = new double[score.length];
        for(int i=0; i<score.length; i++) {
            average[i] = Arrays.stream(score[i]).average().orElse(0.0);
        }

        int[] rank = new int[average.length];
        for(int i=0; i<average.length; i++) {
            int count = 1;
            for(int j=0; j<average.length; j++) {
                if(average[i] < average[j]) {
                    count++;
                }
            }
            rank[i] = count;
        }

        return rank;
    }
}