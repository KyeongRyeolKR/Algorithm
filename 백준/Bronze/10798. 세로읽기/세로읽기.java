import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Queue<String>> queueList = new ArrayList<>();
        for(int i=0; i<5; i++) {
            queueList.add(new LinkedList<>());
        }

        for(int i=0; i<5; i++) {
            queueList.get(i).addAll(List.of(sc.nextLine().split("")));
        }

        int maxLength = queueList.stream()
                .mapToInt(Queue::size)
                .max()
                .getAsInt();

        int index = 0;
        for(int i=0; i<maxLength * 5; i++) {
            Queue<String> queue = queueList.get(index++);
            
            if(index == 5) {
                index = 0;
            }
            
            if(queue.isEmpty()) {
                continue;
            }

            System.out.print(queue.poll());
        }
    }
}