import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int p = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(a);
        while(true) {
            int sum = Arrays.stream(String.valueOf(list.get(list.size()-1)).split(""))
                    .mapToInt(e -> (int) Math.pow(Integer.parseInt(e), p))
                    .sum();

            if(list.contains(sum)) {
                int index = list.indexOf(sum);
                System.out.println(index);
                break;
            }

            list.add(sum);
        }
    }
}