import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String exp;
    static int[] nums;
    static String[] opers;
    static Number[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        exp = sc.next();
        if(!exp.startsWith("-")) {
            exp = "+" + exp;
        }

        nums = getPureNumbers();

        opers = getOperations();

        if(nums.length < 3 || isAllSameOperations()) {
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                if(opers[i].equals("+")) {
                    sum += nums[i];
                } else {
                    sum -= nums[i];
                }
            }
            System.out.println(sum);
            return;
        }

        numbers = getNumbers();

        int total = 0;
        for(int i=0; i<numbers.length; i++) {
            if(i == numbers.length-1) {
                if(opers[i].equals("+")) {
                    total += nums[i];
                } else {
                    total -= nums[i];
                }
                break;
            }
            if(numbers[i].op.equals("-")) {
                int tempTotal = numbers[i].value;
                int cursor = i+1;
                while(numbers[cursor].op.equals("+")) {
                    tempTotal += numbers[cursor].value;
                    cursor++;
                    if(cursor==numbers.length) {
                        break;
                    }
                }
                i = cursor-1;
                total -= tempTotal;
            } else {
                total += numbers[i].value;
            }
        }

        System.out.println(total);
    }

    private static boolean isAllSameOperations() {
        return Arrays.stream(opers).allMatch(op -> op.equals("+")) || Arrays.stream(opers).allMatch(op -> op.equals("-"));
    }

    private static Number[] getNumbers() {
        Number[] numbers = new Number[nums.length];

        for(int i=0; i<nums.length; i++) {
            numbers[i] = new Number(opers[i], nums[i]);
        }

        return numbers;
    }

    private static String[] getOperations() {
        String[] operations = new String[nums.length];

        int index = 0;
        for(int i = 0; i< exp.length(); i++) {
            if(isOperation(exp.charAt(i))) {
                operations[index++] = String.valueOf(exp.charAt(i));
            }
        }

        return operations;
    }

    private static int[] getPureNumbers() {
        return Arrays.stream(exp.split("[+-]"))
                .filter(e -> !e.isBlank())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isOperation(char ch) {
        return !Character.isDigit(ch);
    }
}

class Number {
    String op;
    int value;

    public Number(String op, int value) {
        this.op = op;
        this.value = value;
    }
}