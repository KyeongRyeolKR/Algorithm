import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        int t;
        int i = 0;

        String[] ant = new String[2];
        while(i < 2) {
            ant[i] = sc.nextLine();
            i++;
        }
        t = sc.nextInt();

        if (t > n1 + n2) {
            t = n1 + n2 - 1;
        }
        
        StringBuilder sb0 = new StringBuilder(ant[0]);

        ant[0] = sb0.reverse().append(ant[1]).toString();
        char[] ants = ant[0].toCharArray();
        boolean[] check = new boolean[n1 + n2];

        for (i = 0; i < n1; i++)
            check[i] = true;
        for (; i < n1+ n2; i++)
            check[i] = false;


        while(t-- > 0) {
            for (i = 0; i < n1 + n2 - 1; i++ ) {
                if (check[i] && !check[i+1]) {
                    char tmp = ants[i];
                    ants[i] = ants[i+1];
                    ants[i+1] = tmp;
                    
                    boolean tmp2 = check[i];
                    check[i] = check[i+1];
                    check[i+1] = tmp2;

                    i++;
                }
            }
        }

        for (char ch: ants)
            System.out.print(ch);
    }
}