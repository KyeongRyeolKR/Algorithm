import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    static int n, m;
    static Set<String> keywords;
    static String[] usedWords;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        keywords = new HashSet<>();
        for(int i=0; i<n; i++) {
            keywords.add(br.readLine());
        }

        used = new boolean[n];

        for(int post=0; post<m; post++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            usedWords = st2.nextToken().split(",");

            for(int i=0; i<usedWords.length; i++) {
                keywords.remove(usedWords[i]);
            }

            System.out.println(keywords.size());
        }
    }
}