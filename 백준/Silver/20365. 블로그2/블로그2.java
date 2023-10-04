import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = sc.next().split("");
//        System.out.println(Arrays.toString(arr));

        int count = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i].equals(arr[n-1])) continue;
            if(!arr[i].equals(arr[i+1])) {
                count++;
            }
        }

        System.out.println(count+1);
    }
}