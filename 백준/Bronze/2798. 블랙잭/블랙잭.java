import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] cards = new int[N];
        for(int i=0; i<N; i++){
            cards[i] = sc.nextInt();
        }

        int result = 0;
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum == M){
                        System.out.println(sum);
                        return;
                    }
                    if(sum < M && result < sum){
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}