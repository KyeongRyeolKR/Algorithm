import java.util.*;

public class Main {

    static final String POLY_1 = "AAAA";
    static final String POLY_2 = "BB";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        s = s.replaceAll("XXXX", POLY_1);
        s = s.replaceAll("XX", POLY_2);

        if(s.contains("X")) {
            System.out.println(-1);
            return;
        }

        System.out.println(s);
    }
}