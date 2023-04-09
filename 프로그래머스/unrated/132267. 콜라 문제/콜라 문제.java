class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int extra = 0;
         do {
            extra = (n / a) * b + (n % a);
            answer += n / a * b;
            n = extra;
        } while(extra >= a);
        
        return answer;
    }
}