class Solution {
    public String solution(String my_string, int n) {
        StringBuilder builder = new StringBuilder();
        for(char x : my_string.toCharArray()){
            builder.append(String.valueOf(x).repeat(n));
        }
        return builder.toString();
    }
}