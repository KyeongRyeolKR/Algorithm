import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal val = sc.nextBigDecimal();

        int n = sc.nextInt();

        BigDecimal result = val.pow(n);

        System.out.println(result.toPlainString());
    }
}