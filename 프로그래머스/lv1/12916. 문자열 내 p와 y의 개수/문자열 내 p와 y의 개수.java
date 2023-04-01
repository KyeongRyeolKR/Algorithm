import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        int count1 = (int) Arrays.stream(s.split(""))
                .filter(e -> e.equalsIgnoreCase("p"))
                .count();

        int count2 = (int) Arrays.stream(s.split(""))
                .filter(e -> e.equalsIgnoreCase("y"))
                .count();

        return count1 == count2;
    }
}