import java.io.*;
import java.util.*;

public class Main {

    static int n, r, c;
    static int count = 0;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        find((int)Math.pow(2, n), 0, 0);
    }

    public static void find(int size, int x, int y) {
        if (x == r && y == c) {
            System.out.println(count);
            return;
        }

        if (r < x + size && r >= x && c < y + size && c >= y) {
            int newSize = size / 2; 

            find(newSize, x, y);
            find(newSize, x, y + newSize); 
            find(newSize, x + newSize, y); 
            find(newSize, x + newSize, y + newSize);
        } else {
            count += size * size;
        }
    }
}