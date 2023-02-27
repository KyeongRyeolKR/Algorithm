class Solution {
    public String solution(String cipher, int code) {
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = code; i <= cipher.length(); i += code) {
            builder.append(cipher.charAt(i - 1));
        }
        
        return builder.toString();
    }
}