import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        String str = "";

        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(s.compareTo(time) >= 0) {
                before.add(name);
            } else if(e.compareTo(time) <= 0 && q.compareTo(time) >= 0) {
                after.add(name);
            }
        }

        int answer = 0;
        for(String name : nameSet) {
            if(before.contains(name) && after.contains(name)) {
                answer += 1;
            }
        }
        
        System.out.println(answer);
    }
}