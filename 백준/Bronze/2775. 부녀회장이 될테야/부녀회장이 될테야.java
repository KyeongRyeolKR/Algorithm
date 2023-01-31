import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int floorNum = sc.nextInt();
            int roomNum = sc.nextInt();

            int[] zero = new int[roomNum];
            for(int j=0; j<roomNum; j++){
                zero[j] = j+1;
            }

            nextArr(zero, roomNum, floorNum);
        }
    }
    public static void nextArr(int[] arr, int roomNum, int floorNum){
        int[] next = new int[roomNum];
        next[0] = 1;
        for (int k = 1; k < roomNum; k++) {
            next[k] = next[k - 1] + arr[k];
        }

        if(floorNum == 0) {
            System.out.println(arr[roomNum-1]);
            return;
        }
        nextArr(next, roomNum, floorNum-1);
    }
}