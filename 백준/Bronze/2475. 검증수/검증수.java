import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = new int[5];

        main.inputNumber(arr);
        int[] result = main.squareAll(arr);
        System.out.println(main.finalResult(result));
    }

    private void inputNumber(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
    }

    private int[] squareAll(int[] arr){
        int[] result = new int[5];
        for(int i=0; i<arr.length; i++) {
            result[i] = arr[i] * arr[i];
        }
        return result;
    }

    private int finalResult(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum%10;
    }
}
