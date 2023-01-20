import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while(tokenizer.hasMoreTokens()){
            count++;
            tokenizer.nextToken();
        }

        System.out.println(count);
    }
}
