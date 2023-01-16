import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        for(int i=0; i<array.length; i++){
            array[i] = scanner.next();
        }

        for(int i=0; i<array.length; i++){
            int count = 0;
            int sum = 0;
            for(int j=0; j<array[i].length(); j++){
                if(array[i].charAt(j) == 'O'){
                    count++;
                } else {
                    count = 0;
                }
                sum += count;
            }
            System.out.println(sum);
        }

    }
}