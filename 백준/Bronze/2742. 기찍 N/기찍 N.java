import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int number = sc.nextInt();
        main.printlnFromNumberToOne(number);
    }

    private void printlnFromNumberToOne(int number){
        for(int i=number; i>0; i--){
            System.out.println(i);
        }
    }
}
