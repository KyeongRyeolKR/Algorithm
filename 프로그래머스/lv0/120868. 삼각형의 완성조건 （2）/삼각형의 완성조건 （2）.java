class Solution {
    public int solution(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        int count = 0;
        for(int i=max+1; i<sides[0]+sides[1]; i++) {
            count++;
        }

        for(int i=1; i<=max; i++) {
            if(min + i > max) {
                count++;
            }
        }

        return count;
    }
}