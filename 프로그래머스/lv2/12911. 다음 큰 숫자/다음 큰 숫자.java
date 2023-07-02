class Solution {
    public int solution(int n) {
        int n_ = Integer.bitCount(n);

        int m = n+1;
        while(true) {
            int m_ = Integer.bitCount(m);

            if(n_ == m_) return m;

            m++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }
}