import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        if(my_string.contains("-")) {
            my_string = my_string.replaceAll("- ", "+ -");
        }

        return Arrays.stream(my_string.split(" \\+ "))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}