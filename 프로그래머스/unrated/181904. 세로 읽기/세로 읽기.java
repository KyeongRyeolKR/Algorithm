class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";

        String[] arr = my_string.split("");

        String temp = "";
        for(int i=0; i<arr.length; i++) {
            temp += arr[i];
            if((i+1) % m == 0) {
                answer += temp.charAt(c-1);
                temp = "";
            }
        }

        return answer;
    }
}