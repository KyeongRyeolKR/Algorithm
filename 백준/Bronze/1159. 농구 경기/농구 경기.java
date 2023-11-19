import java.util.Scanner;

public class Main {

    static int[] alpha = new int[26];
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        
        for(int i = 0; i < a; i++){
            String s = sc.next();
            addAlpha(s);
        }

        checkAlpha();
    }

    static void addAlpha(String a){
        char c = a.charAt(0);
        alpha[c - 'a']++;
    }

    static void checkAlpha(){
        boolean b = false;

        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] >= 5) 
            {
                System.out.print((char)(i+'a'));
                b = true;
            }
        }

        if(!b) System.out.println("PREDAJA");
    } 
}