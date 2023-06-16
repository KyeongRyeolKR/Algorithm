class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            String left = my_string.substring(0, query[0]);
            String right = my_string.substring(query[1]+1);
            String center = new StringBuilder(my_string.substring(query[0], query[1]+1)).reverse().toString();
            my_string = left + center + right;
        }
        return my_string;
    }
}