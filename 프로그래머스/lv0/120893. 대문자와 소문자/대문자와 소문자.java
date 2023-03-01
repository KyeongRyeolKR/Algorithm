class Solution {
    public String solution(String my_string) {
        char[] arr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            if(c >= 65 && c <= 90) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }
}