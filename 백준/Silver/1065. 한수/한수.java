import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main T = new Main();
        int n = scanner.nextInt();
        System.out.println(T.solution(n));
    }

    public int solution(int n){
        int answer = 99;
        ArrayList<Integer> arr = new ArrayList<>();
        if(n < 100){
            return n;
        }
        for(int i=100; i<=n; i++){
            arr.clear();
            int num = i;
            while(num != 0){
                arr.add(num%10);
                num = num / 10;
            }
            Iterator<Integer> iterator = arr.iterator();
            int[] sooyeol = new int[arr.size()];
            int index = 0;
            while(iterator.hasNext()){
                sooyeol[index] = iterator.next();
                index++;
            }
            int diff = sooyeol[sooyeol.length-1] - sooyeol[sooyeol.length-2];
            boolean OK = false;
            for(int j=sooyeol.length-2; j>0; j--){
                if(diff == (sooyeol[j] - sooyeol[j-1])){
                    OK = true;
                } else {
                    OK = false;
                }
            }
            if(OK){
                answer++;
            }
        }

        return answer;
    }
}