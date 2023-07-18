import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=s.length(); i++) {
            String temp = "";
            String[] nSplit = splitString(s, i);

            int count = 1;
            for(int j=0; j<nSplit.length-1; j++) {
                if(nSplit[j].equals(nSplit[j+1])) {
                    count++;
                } else {
                    if(count > 1) {
                        temp += count;
                    }
                    temp += nSplit[j];
                    count = 1;
                }
                if(j == nSplit.length-2) {
                    if(count > 1) {
                        temp += count;
                    }
                    temp += nSplit[j+1];
                }
            }

            if(temp.length() < min && !temp.isBlank()) {
                min = temp.length();
            }
        }

        return min;
    }

    private static String[] splitString(String input, int n) {
        List<String> splitList = new ArrayList<>();
        int length = input.length();

        for (int i = 0; i < length; i += n) {
            if (i + n <= length) {
                splitList.add(input.substring(i, i + n));
            } else {
                splitList.add(input.substring(i));
                break;
            }
        }

        return splitList.toArray(new String[0]);
    }
}