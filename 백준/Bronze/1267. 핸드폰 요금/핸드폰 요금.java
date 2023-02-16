import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] callTimes = new int[n];
        for(int i=0; i<n; i++){
            callTimes[i] = sc.nextInt();
        }

        int resultY = 0;
        int resultM = 0;
        for(int time : callTimes){
            resultY += (time/30+1) * 10;
            resultM += (time/60+1) * 15;
        }

        if(resultY == resultM) {
            System.out.printf("Y M %d", resultY);
        } else if(resultY > resultM){
            System.out.printf("M %d", resultM);
        } else {
            System.out.printf("Y %d", resultY);
        }
    }
}