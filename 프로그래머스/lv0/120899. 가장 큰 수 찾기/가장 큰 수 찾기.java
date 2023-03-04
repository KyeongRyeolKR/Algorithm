import java.util.Arrays;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];

        int[] subArr = array.clone();
        
        Arrays.sort(array);
        answer[0] = array[array.length-1];
        
        for(int i=0; i<subArr.length; i++) {
            if(answer[0] == subArr[i]) {
                answer[1] = i;
            }
        }
        
        return answer;
    }
}