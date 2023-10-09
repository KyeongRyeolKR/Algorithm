import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String exp = sc.next();

        String[] split = exp.split("-");

        for(int i=0; i<split.length; i++) {
            if(split[i].contains("+")) {
                String[] temp = split[i].split("\\+");
                
                int sum = Arrays.stream(temp)
                        .mapToInt(Integer::parseInt)
                        .sum();
                
                split[i] = String.valueOf(sum);
            }
        }

        int answer = Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .reduce((e1, e2) -> e1 - e2)
                .orElseThrow();
        
        System.out.println(answer);
    }
}