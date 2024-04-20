import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static int[] tree;
    
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        tree=new int[n];
        for(int i=0;i<n;i++){
            tree[i]=sc.nextInt();
        }
        
        Arrays.sort(tree);
        
        int gcd=0;
        for(int i=0; i<n-1; i++){
            int distance = tree[i+1] - tree[i];
            gcd = getGcd(distance,gcd);
        }
        
        System.out.println((tree[n-1]-tree[0])/gcd+1-(tree.length));
    }

    private static int getGcd(int a, int b) {
        if(b==0) {
            return a;
        } else {
            return getGcd(b,a%b);
        }
    }
}