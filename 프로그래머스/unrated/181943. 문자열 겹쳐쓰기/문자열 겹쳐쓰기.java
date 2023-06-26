class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String[] origin = my_string.split("");
        String[] overwrite = overwrite_string.split("");

        int subIndex = 0;
        for (int i = s; i < s + overwrite.length; i++) {
            origin[i] = overwrite[subIndex++];
        }

        return String.join("", origin);
    }
}