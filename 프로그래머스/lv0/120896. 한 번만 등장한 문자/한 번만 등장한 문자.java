import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] arr = new int[s.length()];
        String[] sArr = s.split("");
        Arrays.sort(sArr);
        for(int i=0; i<sArr.length; i++) {
            int cnt = 0;
            for(int j=0; j<sArr.length; j++) {
                if(sArr[i].equals(sArr[j])) cnt++;
            }
            arr[i] = cnt;
        }


        String answer = "";
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) answer += sArr[i];
        }

        return answer;
    }
}