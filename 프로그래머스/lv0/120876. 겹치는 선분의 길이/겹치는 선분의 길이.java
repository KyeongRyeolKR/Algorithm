class Solution {
    public int solution(int[][] lines) {
        int answer = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<lines.length; i++) {
            for(int j=0; j<lines[i].length; j++) {
                if(lines[i][j] > max) {
                    max = lines[i][j];
                }
                if(lines[i][j] < min) {
                    min = lines[i][j];
                }
            }
        }

//        System.out.println("max = " + max);
//        System.out.println("min = " + min);
//        System.out.println(Arrays.deepToString(lines));

        for(int i=0; i<lines.length; i++) {
            for(int j=0; j<lines[i].length; j++) {
                lines[i][j] -= min;
            }
        }

//        System.out.println(Arrays.deepToString(lines));

        int[] count = new int[max-min];
        for(int i=0; i<3; i++) {
            for(int j=lines[i][0]; j<lines[i][1]; j++) {
                count[j]++;
            }
        }

//        System.out.println(Arrays.toString(count));

        for(int i=0; i<count.length; i++) {
            if(count[i] > 1) {
                answer++;
            }
        }

        return answer;
    }
}