import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {

    static List<Egg> arr;
    static int n;
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");

            int power = Integer.parseInt(str[0]);
            int weight = Integer.parseInt(str[1]);
            arr.add(new Egg(power, weight));
        }

        find(0, 0);

        System.out.println(max);
    }

    public static class Egg {
        int power;
        int weight;

        Egg(int power, int weight) {
            this.power = power;
            this.weight = weight;
        }
    }

    public static void find(int cur, int cnt) {
        if(max < cnt) {
            max = cnt;
        }

        if(cur == n) {
            return;
        }
        
        if(arr.get(cur).power <= 0) {
            find(cur + 1, cnt);
        } else {
            for(int i=0; i<n; i++) {
                if(cur == i || arr.get(i).power <= 0) {
                    continue;
                }

                arr.get(cur).power -= arr.get(i).weight;
                arr.get(i).power -= arr.get(cur).weight;

                int newCount = cnt;

                if(arr.get(cur).power <= 0) {
                    newCount++;
                }
                
                if(arr.get(i).power <= 0) {
                    newCount++;
                }

                find(cur + 1, newCount); 

                arr.get(cur).power += arr.get(i).weight;
                arr.get(i).power += arr.get(cur).weight;
            }
        }
    }
}