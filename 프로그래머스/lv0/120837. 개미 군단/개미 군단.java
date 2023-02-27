class Solution {
    public int solution(int hp) {
        int a = hp / 5;
        int b = (hp - (a * 5)) / 3;
        int c = (hp - (a * 5) - (b * 3));

        return a + b + c;
    }
}