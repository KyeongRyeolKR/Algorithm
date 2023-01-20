import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toUpperCase();

        int[] arr = new int[26]; // 영어 알파벳 26개

        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-65]++;
        }

        int max = -1;
        char maxChar = '?';
        for(int i=0; i<26; i++){
            if(max < arr[i]){
                max = arr[i];
                maxChar = (char) (i+65);
            } else if(max == arr[i]){
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
    }
}
