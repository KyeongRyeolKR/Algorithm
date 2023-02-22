class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double x = 0;
        
        x = (double)num1 / num2 * 1000;
        
        answer = (int)x;
        
        return answer;
    }
}