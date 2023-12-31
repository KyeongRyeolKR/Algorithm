import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = Integer.parseInt(sc.nextLine());
        for(int t=0; t<n; t++) {
            String str = sc.nextLine();
            
            Map<String, Integer> map = toMap(str);

            boolean check = isGroupWord(map, str);

            if(check) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGroupWord(Map<String, Integer> lettersAndCountsMap, String groupWord) {
        boolean check = true;

        for (String key : lettersAndCountsMap.keySet()) {
            int count = lettersAndCountsMap.get(key);
            if(count > 1) {
                if(!groupWord.contains(key.repeat(count))) {
                    check = false;
                }
            }
        }
        return check;
    }

    private static Map<String, Integer> toMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] arr = str.split("");
        for (String s : arr) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}