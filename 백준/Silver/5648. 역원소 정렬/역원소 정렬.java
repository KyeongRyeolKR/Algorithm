import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> inputs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder(sc.next()).reverse();
            inputs.add(sb.toString());
        }

        long[] array = inputs.stream().mapToLong(Long::parseLong).sorted().toArray();
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}