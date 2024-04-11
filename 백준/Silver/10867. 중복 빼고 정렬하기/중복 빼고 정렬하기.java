import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(sc.nextInt());
        }

        List<Integer> sorted = set.stream().sorted().collect(Collectors.toList());
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}