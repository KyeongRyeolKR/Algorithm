import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        long sum = Arrays.stream(str)
//                .peek(System.out::println)
                .mapToLong(Long::parseLong)
                .sum();

        System.out.println(sum);
    }
}