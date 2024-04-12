import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            LinkedList<Document> queue = new LinkedList<>();
            for(int i=0; i<n; i++) {
                queue.add(new Document(i, sc.nextInt()));
            }

            int count = 0;
            while(!queue.isEmpty()) {
                Document first = queue.poll();
                boolean isMax = true;

                for(int i=0; i<queue.size(); i++) {
                    if(first.score < queue.get(i).score) {
                        queue.add(first);

                        for(int j=0; j<i; j++) {
                            queue.add(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax) {
                    continue;
                }

                count++;
                if(first.order == m) {
                    break;
                }
            }

            System.out.println(count);
        }
    }
}

class Document {

    int order;
    int score;

    public Document(int order, int score) {
        this.order = order;
        this.score = score;
    }
}