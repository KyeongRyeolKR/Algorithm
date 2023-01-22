import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int n = sc.nextInt();
        sc.nextLine();
        String number = sc.nextLine();
        System.out.println(main.getNumberSum(number, n));
    }

    private int getNumberSum(String number, int length){
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return sum;
    }
}
