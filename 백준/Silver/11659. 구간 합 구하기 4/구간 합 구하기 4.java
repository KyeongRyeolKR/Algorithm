import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberQuantity = sc.nextInt();
        int calcTimes = sc.nextInt();

        int[] numbers = new int[numberQuantity];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = sc.nextInt();
        }

        int[] prefixSum = new int[numberQuantity];

        prefixSum[0] = numbers[0];
        for(int i=1; i<prefixSum.length; i++){
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }

        for(int i=0; i<calcTimes; i++){
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();

            if(startIndex == 1){
                System.out.println(prefixSum[endIndex-1]);
            } else {
                int result = prefixSum[endIndex - 1] - prefixSum[startIndex - 2];
                System.out.println(result);
            }
        }
        
    }
}
