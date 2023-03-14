import java.util.stream.Collectors;

/**
 * "Zbcdefg" => "gfedcbZ"
 * 우선 오름차순으로 작은거부터 정렬시키고, 반대로 뒤집어주면 완성
 */
class Solution {
    public String solution(String s) {
        return new StringBuilder(
                s.chars()
                .sorted()
                .mapToObj(Character::toString)
                .collect(Collectors.joining())
        ).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("ZabsdSGw"));
    }
}