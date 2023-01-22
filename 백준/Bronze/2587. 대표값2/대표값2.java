import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = main.getIntArray();
        System.out.println(main.getAverage(arr));
        System.out.println(main.getMiddleValue(arr));
    }

    private int[] getIntArray(){
        int[] array = new int[5];
        for(int i=0; i<5; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }

    private int getAverage(int[] array){
        return getSum(array)/array.length;
    }

    private int getMiddleValue(int[] array){
        Arrays.sort(array);
        return array[2];
    }

    private int getSum(int[] array){
        int sum = 0;
        for(int x : array){
            sum += x;
        }
        return sum;
    }
}
