import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        int cookTime = scanner.nextInt();
        int resultMinute= h * 60 + m + cookTime;

        h = resultMinute / 60;
        if(h >= 24){
            h -= 24;
        }
        m = resultMinute % 60;

        System.out.println(h + " " + m);
    }
}