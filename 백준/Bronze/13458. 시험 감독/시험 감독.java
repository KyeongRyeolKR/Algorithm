import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] students = new int[n];
        for(int i=0; i<n; i++) {
            students[i] = sc.nextInt();
        }
        int main = sc.nextInt();
        int sub = sc.nextInt();

        long answer = 0;
        for(int i=0; i<students.length; i++) {
            answer++;
            if(students[i] <= main) {
                continue;
            }
            students[i] -= main;
            answer += students[i] / sub;
            if(students[i] % sub > 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}