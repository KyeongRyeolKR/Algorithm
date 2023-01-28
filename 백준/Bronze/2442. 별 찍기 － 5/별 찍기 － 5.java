import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=1; j<2*n; j++){
                if(i+j < n){
                    System.out.print(" ");
                } else if(i+j == n) {
                    for(int k=0; k<(i+1)*2-1; k++) {
                        System.out.print("*");
                    }
                    break;
                }
            }
            if(i != n-1) {
                System.out.println();
            }
        }
    }
}