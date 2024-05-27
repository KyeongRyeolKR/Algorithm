class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase().replaceAll("[^0-9a-z-_.]","").replaceAll("[.]{2,}",".");
        
        if(answer.charAt(0) == '.')
            answer = answer.substring(1);
        if(answer.length() > 1 && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0,answer.length()-1);

        if(answer.isEmpty())
            answer = "a";

        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1) == '.')
                answer = answer.substring(0, answer.length()-1);
        }

        while(answer.length() < 3){
            answer = answer.concat(answer.substring(answer.length()-1));
        }

        return answer;
    }
}