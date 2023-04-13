class Solution {
    public String solution(int[] food) {
        String answer = "";

        for(int i=1; i<food.length; i++) {
            int divide = food[i] / 2;
            if(divide == 0) continue;

            answer += String.valueOf(i).repeat(divide);
        }

        StringBuilder reverse = new StringBuilder(answer).reverse();

        answer += "0" + reverse;
        
        return answer;
    }
}