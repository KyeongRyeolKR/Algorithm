class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        if(!X.isEmpty() && !Y.isEmpty()){
            for(int i = 0; i < 10; i++){
                String number = String.valueOf(9 - i);
                int xLen = X.length() - X.replace(number, "").length();
                int yLen = Y.length() - Y.replace(number, "").length();
                int min = Math.min(xLen, yLen);

                if(min > 0){
                    sb.append(number.repeat(min));
                }
            }
        }

        String answer = sb.toString();

        if(answer.isEmpty()){
            answer = "-1";
        } else if(answer.replace("0", "").isEmpty()) {
            answer = "0";
        }

        return answer;
    }
}