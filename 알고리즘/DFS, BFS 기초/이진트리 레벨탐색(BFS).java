import java.util.*;

public class Main {
    Node root;

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
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");

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

            level++;
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