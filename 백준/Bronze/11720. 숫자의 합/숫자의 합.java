import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Input11720 in = new Input11720(sc.nextInt(), sc.next());        // 1. 인풋 값 객체화

        List<Integer> numbers = toNumberOfDigits(in.getNumber());  // 2. 문자열로 이루어진 숫자를 각 자리수(정수)로 변환하여 리스트로 반환
        
        int result = sumList(numbers);                 // 3. 리스트를 스트림으로 변환하여 누적 합을 반환

        System.out.println(result);                    // 4. 결과 출력
    }

    // 2.
    private static List<Integer> toNumberOfDigits(String number){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<number.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return result;
    }

    // 3.
    private static int sumList(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

/**
 * 초기 값을 담는 엔티티 클래스
 */
class Input11720 {
    private int count;
    private String number;

    public Input11720(int count, String number) {
        this.count = count;
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
