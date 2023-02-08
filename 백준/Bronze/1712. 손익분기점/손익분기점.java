import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());   // 고정비용
        int b = Integer.parseInt(st.nextToken());   // 생산비용
        int c = Integer.parseInt(st.nextToken());   // 판매가격

        int result = 0;
        if (c <= b) {
            System.out.println(-1);
        } else {
            result = a / (c - b);
            System.out.println(result + 1);
        }
    }
}