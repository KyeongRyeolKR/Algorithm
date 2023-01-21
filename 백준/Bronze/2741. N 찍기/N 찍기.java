import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int n = sc.nextInt();

        main.printFromOneToNumber(n);
    }

    private void printFromOneToNumber(int number){
        for(int i=1; i<=number; i++){
            System.out.println(i);
        }
    }
}
