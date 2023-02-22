class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < can.length; j++) {
                if (babbling[i].contains(can[j])) {
                    babbling[i] = babbling[i].replaceFirst(can[j], " ");
                }
            }
        }

        for(String x : babbling){
            if(x.replaceAll(" ", "").equals("")){
                answer++;
            }
        }

        return answer;
    }
}