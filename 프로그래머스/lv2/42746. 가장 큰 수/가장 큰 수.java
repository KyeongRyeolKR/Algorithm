import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(array, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if(array[0].equals("0")) {
            return "0";
        }

        return String.join("", array);
    }
}