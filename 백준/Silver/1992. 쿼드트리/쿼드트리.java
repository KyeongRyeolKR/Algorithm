import java.util.Scanner;

public class Main {

    public static int[][] img;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        img = new int[n][n];

        for(int i=0; i<n; i++) {
            String str = sc.next();

            for(int j=0; j<n; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, n);
        
        System.out.println(sb);
    }

    public static void quadTree(int x, int y, int size) {
        if(isPossible(x, y, size)) {
            sb.append(img[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');
        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);
        sb.append(')');
    }


    public static boolean isPossible(int x, int y, int size) {
        int value = img[x][y];

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(value != img[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}