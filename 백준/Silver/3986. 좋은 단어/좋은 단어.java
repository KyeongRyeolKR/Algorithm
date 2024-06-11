import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int count = 0;
        for(int t=0; t<n; t++) {
            Stack<String> stack = new Stack<>();
            String[] input = sc.nextLine().split("");

            if(input.length % 2 != 0) {
                continue;
            }

            for(int i=0; i<input.length; i++) {
                if(stack.isEmpty()) {
                    stack.add(input[i]);
                    continue;
                }

                String peek = stack.peek();
                if(peek.equals(input[i])) {
                    stack.pop();
                } else {
                    stack.add(input[i]);
                }
            }

            if(stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}