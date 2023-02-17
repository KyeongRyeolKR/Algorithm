import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] directories = new String[n];
        for (int i = 0; i < n; i++) {
            directories[i] = sc.next();
        }

        if (n == 1) {
            System.out.println(directories[0]);
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < directories[0].length(); i++) {
            boolean isEqual = false;
            for (int j = 0; j < directories.length - 1; j++) {
                if (directories[j].charAt(i) != directories[j + 1].charAt(i)) {
                    result.append("?");
                    isEqual = false;
                    break;
                } else {
                    isEqual = true;
                }
            }
            if (isEqual) {
                result.append(directories[0].charAt(i));
            }
        }

        System.out.println(result);
    }
}