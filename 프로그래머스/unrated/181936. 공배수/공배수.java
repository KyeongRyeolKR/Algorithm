class Solution {
    public int solution(int number, int n, int m) {
        int lcm = n * m / getGCD(n, m);

        for(int i=1; i<=100; i++) {
            int temp = lcm * i;
            if(temp == number) return 1;
        }

        return 0;
    }

    public int getGCD(int num1, int num2) {
        if(num2 == 0) return num1;
        return getGCD(num2, num1%num2);
    }
}