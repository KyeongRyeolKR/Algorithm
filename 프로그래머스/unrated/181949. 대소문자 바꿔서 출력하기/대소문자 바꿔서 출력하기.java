import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        
        char[] charArray = a.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(Character.isLowerCase(charArray[i])) {
                sb.append(String.valueOf(charArray[i]).toUpperCase());
            } else {
                sb.append(String.valueOf(charArray[i]).toLowerCase());
            }
        }

        System.out.println(sb);
    }
}