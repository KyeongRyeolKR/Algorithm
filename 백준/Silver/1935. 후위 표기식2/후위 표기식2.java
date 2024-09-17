import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Map<String, Double> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String expression = sc.next();
        map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(Character.toString(65+i), sc.nextDouble());
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(!Character.isAlphabetic(c)) {
                Double value1 = stack.pop();
                Double value2 = stack.pop();

                double result = calculate(value1, value2, c);
                
                stack.add(result);
            } else {
                stack.add(map.get(Character.toString(c)));
            }
        }

        System.out.printf("%.2f", stack.get(0));
    }

    private static double calculate(Double value1, Double value2, char op) {
        switch (op) {
            case '*':
                return value2 * value1;
            case '/':
                return value2 / value1;
            case '+':
                return value2 + value1;
            case '-':
                return value2 - value1;
            default:
                return 0;
        }
    }
}