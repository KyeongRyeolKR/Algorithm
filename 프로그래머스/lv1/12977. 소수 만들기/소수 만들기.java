import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        // 3개의 수를 더해서 만들 수 있는 모든 경우를 구하기 위해 3중 for문 사용
        for(int i=0; i<len-2; i++) {
            for(int j=i+1; j<len-1; j++) {
                for(int k=j+1; k<len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer++; // 소수인 경우 answer 증가
                }
            }
        }
        
        return answer;
    }
    
    // 소수 판별 함수
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}