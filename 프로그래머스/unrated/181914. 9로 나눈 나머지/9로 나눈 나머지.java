class Solution {
    public int solution(String number) {
        return number.chars()
                .map(e -> e - '0')
                .sum() % 9;
    }
}