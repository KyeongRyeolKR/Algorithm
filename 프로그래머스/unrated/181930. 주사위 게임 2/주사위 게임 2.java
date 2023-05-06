class Solution {
    public int solution(int a, int b, int c) {
        boolean sameAll = a == b && b == c;
        boolean same2 = a == b || b == c || a == c;

        int pow1 = a + b + c;
        int pow2 = (int) (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int pow3 = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
        int score = 0;
        
        if(sameAll) score = pow1 * pow2 * pow3;
        else if(same2) score = pow1 * pow2;
        else score = pow1;

        return score;
    }
}