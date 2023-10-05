import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int n;
    private static Condition[] conditions;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        conditions = new Condition[n];
        for(int i=0; i<n; i++) {
            conditions[i] = new Condition(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for(int i=111; i<=999; i++) {
            int[] split = splitNumber(i);

            if(isDuplicated(split) || hasZero(split)) {
//                System.out.println(Arrays.toString(split) + " 해당 숫자는 불가능합니다.");
                continue;
            }

//            System.out.println(Arrays.toString(split));

            add(i);
        }

//        System.out.println(list);
        System.out.println(list.size());
    }

    private static void add(int num) {
        boolean strikeFlag = true;
        boolean ballFlag = true;

        for(int i=0; i<n; i++) {
            int strikeCount = strikeCount(conditions[i].num, num);
            int ballCount = ballCount(conditions[i].num, num);

            if(strikeCount != conditions[i].strike) {
//                System.out.println("\n스트라이크 개수가 다릅니다.");
                strikeFlag = false;
            }

            if(ballCount-strikeCount != conditions[i].ball) {
//                System.out.println("\n볼 개수가 다릅니다.");
                ballFlag = false;
            }
        }

        if(strikeFlag && ballFlag) {
            list.add(num);
        }
    }

    private static int ballCount(int num1, int num2) {
        int count = 0;
        int[] split1 = splitNumber(num1);
        int[] split2 = splitNumber(num2);
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(split1[i] == split2[j]) {
                    count++;
                }
            }
        }
//        System.out.print(count + " ");
        return count;
    }

    private static int strikeCount(int num1, int num2) {
        int count = 0;
        int[] split1 = splitNumber(num1);
        int[] split2 = splitNumber(num2);
        for(int i=0; i<3; i++) {
            if(split1[i] == split2[i]) {
                count++;
            }
        }
//        System.out.print(count + " ");
        return count;
    }

    private static boolean hasZero(int[] digits) {
        return Arrays.stream(digits)
                .anyMatch(e -> e == 0);
    }

    private static boolean isDuplicated(int[] digits) {
        return digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2];
    }

    private static int[] splitNumber(int num) {
        int[] split = new int[3];
        split[0] = num / 100;
        split[1] = (num - (split[0]*100)) / 10;
        split[2] = (num - (split[0]*100)) % 10;
        return split;
    }
}

class Condition {
    int num;
    int strike;
    int ball;

    public Condition(int num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}