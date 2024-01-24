import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();
        int changeCount = 0;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) != num.charAt(i)) ++changeCount;
        }

        System.out.println((int) Math.ceil((double) changeCount / 2));
    }
}