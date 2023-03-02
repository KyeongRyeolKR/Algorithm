import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*".repeat(i + 1));
            if (i != n - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}