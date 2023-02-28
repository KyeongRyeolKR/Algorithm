import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        long sum = Arrays.stream(Arrays.stream(str).mapToLong(Long::parseLong).toArray()).sum();

        System.out.println(sum);
    }
}