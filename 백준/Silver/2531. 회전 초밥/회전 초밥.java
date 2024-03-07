import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int d = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int c = Integer.parseInt(split[3]);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(bf.readLine());
        }

        int start = 0;
        int end = start + k - 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            start = i;
            end = (start + k - 1) % n;
            if (start > end) {
                for (int j = start; j < n; j++) {
                    set.add(nums[j]);
                }

                for (int j = 0; j <= end; j++) {
                    set.add(nums[j]);
                }
            } else {
                for (int j = start; j <= end; j++) {
                    set.add(nums[j]);
                }
            }
            set.add(c);

            if (set.size() > max) {
                max = set.size();
            }
        }

        System.out.println(max);
    }
}