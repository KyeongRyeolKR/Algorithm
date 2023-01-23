import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = new int[10];

        int result = sc.nextInt() * sc.nextInt() * sc.nextInt();

        String resultString = String.valueOf(result);

        for(int i=0; i<resultString.length(); i++){
            arr[Integer.parseInt(String.valueOf(resultString.charAt(i)))]++;
        }

        for(int x : arr) {
            System.out.println(x);
        }
    }

}