class Solution {
    public int solution(int order) {
        return (int) String.valueOf(order).chars()
                .mapToObj(Character::getNumericValue)
                .filter(e -> e == 3 || e == 6 || e == 9)
                .count();
    }
}