import java.util.*;

/**
 * 이진트리 BFS의 동작 원리 구현
 * -> 같은 레벨의 노드들을 전부 탐색한 후, 다음 레벨의 노드들을 탐색한다.
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
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.bfs(tree.root);
    }

    public void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);  // 탐색 시작 노드

        int level = 0;  // 현재 레벨
        while (!queue.isEmpty()) {
            int len = queue.size(); // 현재 레벨에서 탐색할 노드의 개수
            System.out.print(level + " : ");

            // 같은 레벨의 노드들을 전부 순회하며 탐색
            // 탐색중인 노드가 자식 노드를 가지고 있다면, 큐에 추가
            for(int i=0; i<len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");

                if(cur.lt != null) {
                    queue.offer(cur.lt);
                }
                if(cur.rt != null) {
                    queue.offer(cur.rt);
                }
            }

            level++;    // 현재 레벨에서의 모든 탐색이 끝났으니, 다음 레벨로 올림
            System.out.println();
        }
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