import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        String[] arr = my_string.split("");
        for (int index : indices) {
            arr[index] = " ";
        }
        
        return Arrays.stream(arr)
                .filter(e -> !e.equals(" "))
                .collect(Collectors.joining());
    }
}