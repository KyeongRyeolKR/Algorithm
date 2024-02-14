import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            int[] alphabets = new int[26];

            char[] words1 = sc.next().toCharArray();
            char[] words2 = sc.next().toCharArray();

            for (char ch : words1) {
                alphabets[ch - 97]++;
            }

            for (char ch : words2) {
                alphabets[ch - 97]--;
            }

            boolean flag = true;
            for (int j : alphabets) {
                if (j != 0) {
                    flag = false;
                    break;
                }
            }
            System.out.println(flag ? "Possible" : "Impossible");
        }
    }
}