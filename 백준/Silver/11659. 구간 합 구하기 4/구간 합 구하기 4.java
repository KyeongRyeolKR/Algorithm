import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Input11659 in = init();     // 1. 인풋 값 객체화

        int[] prefixSum = getPrefixSum(in.getNumbers());    // 2. 누적 합 배열 만들기

        for (int i = 0; i < in.getCalcTimes(); i++) {   // 3. 각 구간마다 합 출력
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();

            if (startIndex == 1) {
                System.out.println(prefixSum[endIndex - 1]);
            } else {
                System.out.println(prefixSum[endIndex - 1] - prefixSum[startIndex - 2]);
            }
        }

    }

    // 1.
    private static Input11659 init() {
        Input11659 in = new Input11659(sc.nextInt(), sc.nextInt());
        int[] numbers = new int[in.getNumberQuantity()];
        for (int i = 0; i < in.getNumberQuantity(); i++) {
            numbers[i] = sc.nextInt();
        }
        in.setNumbers(numbers);
        return in;
    }

    // 2.
    private static int[] getPrefixSum(int[] numbers) {
        int[] prefixSum = new int[numbers.length];
        prefixSum[0] = numbers[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }
        return prefixSum;
    }
}

/**
 * 초기 값을 담는 엔티티 클래스
 */
class Input11659 {
    private int numberQuantity;
    private int calcTimes;
    private int[] numbers;

    public Input11659(int numberQuantity, int calcTimes) {
        this.numberQuantity = numberQuantity;
        this.calcTimes = calcTimes;
    }

    public int getNumberQuantity() {
        return numberQuantity;
    }

    public void setNumberQuantity(int numberQuantity) {
        this.numberQuantity = numberQuantity;
    }

    public int getCalcTimes() {
        return calcTimes;
    }

    public void setCalcTimes(int calcTimes) {
        this.calcTimes = calcTimes;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}