import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int answer = 0;
        if(n % 2 == 0){
            answer = list.get(0) * list.get(n-1);
        } else {
            int mid = (n/2) + 1;
            answer = list.get(mid-1) * list.get(mid-1);
        }

        System.out.println(answer);

    }
}