class Solution {
    public int solution(int n) {
        String n_ = String.valueOf(n);
        
        String[] each_ = n_.split("");
        
        int[] each = new int[each_.length];
        for(int i=0; i<each_.length; i++) {
            each[i] = Integer.parseInt(each_[i]);
        }
        
        int sum = 0;
        for(int x : each) {
            sum += x;
        }
        
        return sum;
    }
}