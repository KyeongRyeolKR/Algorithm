import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Input1546 in = initInput();     // 1. 인풋 값 객체화

        int max = getMax(in.getScores());    // 2. 객체의 scores 리스트에서 최대값 구하기

        List<Double> newScores = makeNewScores(in.getScores(), max);    // 3. 객체의 scores 리스트와 최대값으로 newScores 리스트 만들기

        double newAverage = getAverage(newScores);     // 4. newScores 리스트의 평균 구하기

        System.out.println(newAverage);        // 5. 새로운 점수들의 평균 출력
    }

    // 1.
    private static Input1546 initInput() {
        Input1546 in = new Input1546();
        in.setSubjectCount(sc.nextInt());
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < in.getSubjectCount(); i++) {
            scores.add(sc.nextInt());
        }
        in.setScores(scores);
        return in;
    }

    // 2.
    private static int getMax(List<Integer> scores) {
        return scores.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    // 3.
    private static List<Double> makeNewScores(List<Integer> scores, int max) {
        List<Double> newScores = new ArrayList<>();
        for (int x : scores) {
            newScores.add((double) x / max * 100);
        }
        return newScores;
    }

    // 4.
    private static double getAverage(List<Double> newScores) {
        return newScores.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }


}

/**
 * 초기 값을 담는 엔티티 클래스
 */
class Input1546 {
    private int subjectCount;
    private List<Integer> scores;

    public Input1546() {
    }

    public int getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(int subjectCount) {
        this.subjectCount = subjectCount;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
