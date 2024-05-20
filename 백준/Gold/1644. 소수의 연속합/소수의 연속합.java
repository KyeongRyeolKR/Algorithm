import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static boolean[] prime;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=n; i++){
            if(!prime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j]=true;
                }
            }
        }
        for(int i=1; i<=n; i++){
            if(!prime[i]) {
                primeNumbers.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int sum=0;
        int count=0;
        while(true) {
            if(sum >= n ) {
                sum -= primeNumbers.get(start++);
            } else if(end == primeNumbers.size()) {
                break;
            } else {
                sum += primeNumbers.get(end++);
            }
            
            if(n==sum) {
                count++;
            }
        }
        System.out.println(count);
    }
}