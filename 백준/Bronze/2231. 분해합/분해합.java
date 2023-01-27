import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int N = sc.nextInt();
        int result = 0;
        int answer = 0;
        for(int i=1; i<=1000000; i++){
            result = i + sumEach(i);
            if(result == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

    }

    private static int sumEach(int number){
        int result = 0;
        String numberStr = String.valueOf(number);
        for(int i=0; i<numberStr.length(); i++){
            result += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return result;
    }
}