import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int solution(String dartResult) {
        List<String> numbers = Arrays.stream(dartResult.split("\\D"))
                .filter(e -> e.length() > 0)
                .collect(Collectors.toList());

        List<String> operators = Arrays.stream(dartResult.split("\\d"))
                .filter(e -> e.length() > 0)
                .collect(Collectors.toList());

        List<Integer> scores = new ArrayList<>();
        for(int i=0; i<numbers.size(); i++) {
            if(operators.get(i).contains("S")) {
                scores.add((int) Math.pow(Double.parseDouble(numbers.get(i)), 1));
            }
            if(operators.get(i).contains("D")) {
                scores.add((int) Math.pow(Double.parseDouble(numbers.get(i)), 2));
            }
            if(operators.get(i).contains("T")) {
                scores.add((int) Math.pow(Double.parseDouble(numbers.get(i)), 3));
            }

            if(operators.get(i).contains("#")) {
                scores.set(i, scores.get(i) * -1);
            }
            if(operators.get(i).contains("*") && i != 0) {
                scores.set(i, scores.get(i) * 2);
                scores.set(i-1, scores.get(i-1) * 2);
            } else if(operators.get(i).contains("*") && i == 0) {
                scores.set(i, scores.get(i) * 2);
            }
        }

        return scores.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
