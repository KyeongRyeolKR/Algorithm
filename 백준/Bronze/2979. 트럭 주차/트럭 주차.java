import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int[][] list = new int[3][2];
        int max = -1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                list[i][j] = sc.nextInt();
                if(list[i][j] > max) {
                    max = list[i][j];
                }
            }
        }

        int[] check = new int[max];
        for(int truck=0; truck<list.length; truck++) {
            for(int time=list[truck][0]; time<list[truck][1]; time++) {
                check[time]++;
            }
        }

        int sum = 0;
        for(int i=0; i<check.length; i++) {
            if(check[i] == 1) {
                sum += A;
            } else if(check[i] == 2) {
                sum += B*2;
            } else if(check[i] == 3) {
                sum += C*3;
            }
        }

        System.out.println(sum);
    }
}