class Solution {
    static int count = 0;
    public int solution(int num) {
        recursive(num);
        return count;
    }

    private long recursive(long num) {
        if(num == 1) {
            return num;
        } else if(count == 500) {
            return count = -1;
        } else {
            count++;

            long newNum = 0;

            if (num % 2 == 0) {
                newNum = num / 2L;
            } else {
                newNum = num * 3L + 1;
            }

            return recursive(newNum);
        }
    }
}