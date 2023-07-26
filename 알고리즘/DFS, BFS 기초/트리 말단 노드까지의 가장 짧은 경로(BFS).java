import java.util.*;

/**
 * 트리의 말단 노드까지의 가장 짧은 경로를 BFS로 구현할 때, 동작 원리 살펴보기
 * 먼저 루트 노드를 시작으로 자식 노드들을 큐에 추가하고 큐에 존재하는 다음 노드들을 반복하며 탐색한다.
 * 현재 노드의 자식 노드가 존재하지 않는다면, 말단 노드이기에 해당 노드의 레벨을 리턴한다.
 * 현재 노드의 자식 노드가 존재한다면, 말단 노드가 아니기에 큐에 추가한다.
 */
public class Main {
    Node root;

    // 기본 값(트리) 세팅
    public static void main(String[] args) {
        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.bfs(tree.root));
    }

    private int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size(); // 같은 레벨의 노드 개수

            // 같은 레벨의 노드 개수만큼 반복 탐색
            for(int i=0; i<len; i++) {
                Node cur = queue.poll();

                // 말단 노드 발견 시 종료
                if(cur.lt == null && cur.rt == null) {
                    return level;
                }

                // 자식 노드가 존재한다면 큐에 추가
                if(cur.lt != null) {
                    queue.add(cur.lt);
                }
                if(cur.rt != null) {
                    queue.add(cur.rt);
                }
            }

            level++;
        }

        return 0;
    }
}

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int val) {
        this.data = val;
        this.lt = null;
        this.rt = null;
    }
}