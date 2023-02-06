import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getGCD(a, b));
        System.out.println(getLCM(a, b));
    }

    private static int getGCD(int a, int b){
        int result = a % b;
        if(result == 0){
            return b;
        }
        return getGCD(b, result);
    }

    private static int getLCM(int a, int b){
        int x = a / getGCD(a, b);
        int y = b / getGCD(a, b);
        int result = x * y * getGCD(a, b);
        return result;
    }
}
