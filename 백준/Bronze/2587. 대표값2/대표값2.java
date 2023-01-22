import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> list = main.getIntList();
        main.printResult(main.getAverage(list), main.getMiddleValue(list));
    }

    private List<Integer> getIntList(){
        List<Integer> array = new ArrayList<>();
        for(int i=0; i<5; i++){
            array.add(sc.nextInt());
        }
        return array;
    }

    private int getAverage(List<Integer> list){
        return getSum(list)/list.size();
    }

    private int getMiddleValue(List<Integer> list){
        Collections.sort(list);
        return list.get(2);
    }

    private int getSum(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void printResult(int average, int middleValue){
        System.out.printf("%d\n%d", average, middleValue);
    }
}
