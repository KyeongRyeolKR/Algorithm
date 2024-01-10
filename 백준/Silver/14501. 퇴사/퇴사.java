import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static Schedule[] schedule;
    static int result;

    public static void main(String[] args) {
        n = sc.nextInt();
        schedule = new Schedule[n];
        for(int i=0; i<n; i++) {
            int days = sc.nextInt();
            int price = sc.nextInt();
            schedule[i] = new Schedule(days, price);
        }

        result = 0;
        
        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int i, int pay) {
        if(i >= n) {
            result = Math.max(pay, result);
            return;
        }

        if(i + schedule[i].days <= n) {
            dfs(i + schedule[i].days, pay + schedule[i].price);
        } else {
            dfs(i + schedule[i].days, pay);
        }
        
        dfs(i + 1, pay);
    }
}

class Schedule {
    int days;
    int price;

    public Schedule(int days, int price) {
        this.days = days;
        this.price = price;
    }
}