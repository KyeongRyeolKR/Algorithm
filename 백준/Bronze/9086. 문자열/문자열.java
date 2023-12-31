import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++) {
            String[] arr = sc.nextLine().split("");

            if(arr.length == 1) {
                System.out.println(arr[0].repeat(2));
                continue;
            }
            System.out.println(arr[0] + arr[arr.length-1]);
        }
    }
}