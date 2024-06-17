import java.util.*;

public class Main {

    final static String ENTER = "enter";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, String> logs = new HashMap<>();
        for(int i=0; i<n; i++) {
            String name = sc.next();
            String log = sc.next();
            
            logs.put(name, log);
        }

        List<String> names = new ArrayList<>(logs.keySet());
        
        names.sort(Comparator.reverseOrder());
        
        for(String name : names) {
            String log = logs.get(name);
            
            if(log.equals(ENTER)) {
                System.out.println(name);
           }
        }
    }
}