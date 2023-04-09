import java.util.Arrays;

class Solution {
    public int solution(String s) {
        String[] name = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        return Integer.parseInt(Arrays.stream(name)
                .reduce(s, (str, n) -> str.replaceAll(n, Integer.toString(Arrays.asList(name).indexOf(n)))));
    }
}