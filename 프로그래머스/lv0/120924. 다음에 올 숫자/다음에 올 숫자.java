class Solution {
    public int solution(int[] common) {
        boolean cha = false;
        boolean bee = false;

        int[] diff = new int[common.length-1];
        for(int i=0; i<common.length-1; i++) {
            diff[i] = common[i+1] - common[i];
            if(i >= 1 && diff[i] == diff[i-1]) {
                cha = true;
                bee = false;
            } else {
                cha = false;
                bee = true;
            }
        }

        if(cha) {
            return common[common.length-1] + diff[0];
        }
        if(bee) {
            int multi = common[1] / common[0];
            int answer = common[0];
            for(int i=0; i<common.length; i++) {
                answer *= multi;
            }
            return answer;
        }

        return 0;
    }
}