import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startIndex = sc.nextInt() - 1;
        int endIndex = sc.nextInt() - 1;

        List<Integer> list = new ArrayList<>();
        for(int i=1; list.size() <= 1000; i++){
            for(int j=0; j<i; j++){
                list.add(i);
            }
        }

        int result = 0;
        for(int i=startIndex; i<=endIndex; i++){
            result += list.get(i);
        }

        System.out.println(result);
    }
}