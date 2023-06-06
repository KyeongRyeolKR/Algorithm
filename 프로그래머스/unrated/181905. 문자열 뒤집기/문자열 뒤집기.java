class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        for(int i=s; i<=e; i++) {
            sb.append(my_string.charAt(i));
        }

        String temp = my_string.substring(s, e+1);
        String reversed = sb.reverse().toString();

        return my_string.replace(temp, reversed);
    }

    public static void main(String[] args) {
        new Solution().solution("Progra21Sremm3", 6, 12);
    }
}