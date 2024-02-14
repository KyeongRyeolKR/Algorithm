import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0; i<word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
        }

        for(int i=0; i<word2.length(); i++) {
            count2[word2.charAt(i) - 'a']++;
        }

        int result = 0;
        for(int i=0; i<26; i++) {
            int compare = count1[i] - count2[i];
            if(compare != 0) {
                result += Math.abs(compare);
            }
        }

        System.out.println(result);
    }
}