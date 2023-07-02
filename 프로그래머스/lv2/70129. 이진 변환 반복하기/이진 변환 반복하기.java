import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int remove = 0;

        while(!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') remove++;
            }

            s = s.replaceAll("0", "");
            int length = s.length();
            s = Integer.toBinaryString(length);

            count++;
        }

        return new int[]{count, remove};
    }
}