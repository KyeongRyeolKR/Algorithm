import java.util.*;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        List<String> list = main.getIntList();
        list = main.reverseInList(list);
        int result = main.getMaxInList(list);
        System.out.println(result);
    }

    private List<String> getIntList(){
        List<String> list = new ArrayList<>();
        for(int i=0; i<2; i++) {
            list.add(sc.next());
        }
        return list;
    }

    private List<String> reverseInList(List<String> list){
        List<StringBuilder> builders = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<2; i++) {
            builders.add(new StringBuilder(list.get(i)));
        }
        for(StringBuilder b : builders){
            result.add(String.valueOf(b.reverse()));
        }
        return result;
    }

    private int getMaxInList(List<String> list){
        return Math.max(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)));
    }

}