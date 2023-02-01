import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Input in = new Input(sc.nextInt(), sc.next());

        List<Integer> numbers = main.toNumberOfDigits(in.getNumber());
        int result = main.sum(numbers);
        
        System.out.println(result);
    }

    // 문자열로 이루어진 숫자를 각 자리수(정수)로 변환하여 리스트로 반환하는 메소드
    private List<Integer> toNumberOfDigits(String number){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<number.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return result;
    }

    // 리스트를 스트림으로 변환하여 누적 합을 반환하는 메소드
    private int sum(List<Integer> numbers){
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

/**
 * 초기 값을 담는 엔티티 클래스
 */
class Input {
    private int count;
    private String number;

    public Input(int count, String number) {
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