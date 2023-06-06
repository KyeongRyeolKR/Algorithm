class Solution {
    public String solution(String myString, String pat) {
        int index = myString.lastIndexOf(pat);

        String answer = "";
        for(int i=0; i<index; i++) {
            answer += myString.charAt(i);
        }

        return answer + pat;
    }
}