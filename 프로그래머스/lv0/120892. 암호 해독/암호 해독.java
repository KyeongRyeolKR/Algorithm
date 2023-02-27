class Solution {
    public String solution(String cipher, int code) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= cipher.length() / code; i++) {
            builder.append(cipher.charAt((code * i) - 1));
        }
        return builder.toString();
    }
}