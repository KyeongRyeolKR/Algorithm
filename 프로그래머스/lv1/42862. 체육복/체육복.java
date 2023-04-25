import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] check = new int[n];
        Arrays.fill(check, 0);

        for (int i = 0; i < lost.length; i++) {
            check[lost[i] - 1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            check[reserve[i] - 1]++;
        }

        System.out.println(Arrays.toString(check));

        int max = -1;

        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) {
                if (i > 0 && check[i - 1] == -1) {
                    check[i]--;
                    check[i - 1]++;
                } else if (i < check.length-1 && check[i + 1] == -1) {
                    check[i]--;
                    check[i + 1]++;
                }
            }
        }
        max = (int) Arrays.stream(check)
                .filter(e -> e >= 0)
                .count();

//        for (int i = check.length - 1; i >= 0; i--) {
//            if (check[i] == 1) {
//                if (i > 0 && check[i - 1] == -1) {
//                    check[i]--;
//                    check[i - 1]++;
//                } else if (i < check.length-1 && check[i + 1] == -1) {
//                    check[i]--;
//                    check[i + 1]++;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(check));

        return max;
    }

    // public static void main(String[] args) {
    //     new MySolution().solution(5, new int[]{2, 4}, new int[]{3});
    // }
}