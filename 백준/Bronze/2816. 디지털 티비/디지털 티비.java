import java.util.Scanner;

public class Main {

    static String[] list;
    static int n, i, j;
    static String temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        i = 0;
        j = 0;
        temp = "";
        list = new String[n];
        for(int i=0; i<n; i++) {
            list[i] = sc.next();
        }

        while(!list[0].equals("KBS1")) {
            if(!list[i].equals("KBS1")) {
                System.out.print("1");
                i++;
            } else {
                System.out.print("4");
                temp = list[i];
                list[i] = list[i-1];
                list[i-1] = temp;
                i--;
            }
        }

        while(!list[1].equals("KBS2")) {
            if(!list[j].equals("KBS2")) {
                System.out.print("1");
                j++;
            } else {
                System.out.print("4");
                temp = list[j];
                list[j] = list[j-1];
                list[j-1] = temp;
                j--;
            }
        }
    }
}