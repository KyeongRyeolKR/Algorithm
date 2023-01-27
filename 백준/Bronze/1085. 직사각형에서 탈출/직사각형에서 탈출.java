import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> hansu = new ArrayList<>();
        hansu.add(sc.nextInt());
        hansu.add(sc.nextInt());

        List<Integer> squareX = new ArrayList<>();
        List<Integer> squareY = new ArrayList<>();
        main.addValues(squareX, sc.nextInt(), squareY, sc.nextInt());

        List<Integer> results = new ArrayList<>();
        for(int i=0; i<2; i++){
            results.add(Math.abs(squareX.get(i) - hansu.get(0)));
        }
        for(int i=0; i<2; i++){
            results.add(Math.abs(squareY.get(i) - hansu.get(1)));
        }

        int min = Integer.MAX_VALUE;
        for(int x : results){
            if(x < min){
                min = x;
            }
        }

        System.out.println(min);
    }

    private void addValues(List<Integer> x, int valueX, List<Integer> y, int valueY){
        x.add(0);
        x.add(valueX);
        y.add(0);
        y.add(valueY);
    }
}