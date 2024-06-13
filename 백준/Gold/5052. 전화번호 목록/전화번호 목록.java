import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] s = new String[n];
            int check = 0;
            for (int j = 0; j < n; j++) {
                s[j] = br.readLine();
            }

            Arrays.sort(s, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            for(int j=1;j<n;j++) {
                if(s[j].startsWith(s[j-1])) {
                    check=1;
                    break;
                }
            }
            
            System.out.println(check == 0 ? "YES" : "NO");
        }
    }
}