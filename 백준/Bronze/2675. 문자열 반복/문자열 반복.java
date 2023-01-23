import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        int testCase = sc.nextInt();
        List<Value> list = main.getValueList(testCase);
        main.printResult(list);
    }

    private List<Value> getValueList(int quantity){
        List<Value> values = new ArrayList<>();
        for(int i=0; i<quantity; i++){
            Value value = new Value(sc.nextInt(), sc.next());
            values.add(value);
        }
        return values;
    }

    private void printResult(List<Value> list){
        for(Value v : list){
            for(int i=0; i<v.getString().length(); i++){
                for(int j=0; j<v.getRepeat(); j++){
                    System.out.print(v.getString().charAt(i));
                }
            }
            System.out.println();
        }
    }
}

class Value {

    private int repeat;
    private String string;

    public Value(int repeat, String string){
        this.repeat = repeat;
        this.string = string;
    }

    public int getRepeat() {
        return repeat;
    }

    public String getString() {
        return string;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Value{")
                .append("repeat='").append(repeat).append('\'')
                .append(", string='").append(string).append('\'')
                .append('}');

        return builder.toString();
    }
}