import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> divisors = getDivisor(brown + yellow);

        int mid1 = divisors.size() / 2;
        int mid2 = divisors.size() / 2;
        if(divisors.size() % 2 == 0) {
            mid2 -= 1;
        }

        while(true) {
            int[] answer;

            answer = new int[]{divisors.get(mid1), divisors.get(mid2)};

            int[][] arr = new int[answer[1]][answer[0]];
            int brownCount = 0;
            int yellowCount = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (i == 0 || i == arr.length - 1 || j == 0 || j == arr[i].length - 1) {
                        brownCount++;
                        arr[i][j] = 1;
                    } else {
                        yellowCount++;
                    }
                }
            }

            if(brownCount == brown && yellowCount == yellow) {
                if(divisors.get(mid1) >= divisors.get(mid2)) {
                    return new int[]{divisors.get(mid1), divisors.get(mid2)};
                }
            }

            mid1++;
            mid2--;
        }
    }

    private List<Integer> getDivisor(int number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                set.add(i);
            }
        }

        return set.stream().sorted().collect(Collectors.toList());
    }
}