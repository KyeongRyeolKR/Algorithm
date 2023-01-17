import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[9];
        for(int i=0; i<array.length; i++){
            array[i] = scanner.nextInt();
        }

        int maxIndex = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i<=array.length; i++){
            if(array[i-1] > maxValue){
                maxValue = array[i-1];
                maxIndex = i;
            }
        }

        System.out.println(maxValue);
        System.out.println(maxIndex);
    }
}