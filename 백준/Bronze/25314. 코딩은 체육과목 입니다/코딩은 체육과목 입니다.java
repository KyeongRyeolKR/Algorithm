import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder builder = new StringBuilder();
        builder.append("long ".repeat(n/4));
        builder.append("int");

        System.out.println(builder);
    }
}