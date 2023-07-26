/**
 * 트리의 말단 노드까지의 가장 짧은 경로를 DFS로 구현할 때, 동작 원리 살펴보기
 * 루트 노드에서 시작해서 자식 노드가 없을 때까지 재귀한다.
 * ps. 최단 거리, 횟수 등을 구하는 알고리즘을 짤 때는 BFS로 푸는 것이 정석이다.
 *     하지만 DFS의 동작 원리를 파악하기 위해 DFS로 풀이한다.
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

        System.out.println(tree.dfs(0, tree.root));
    }

    private int dfs(int level, Node root) {
        // 해당 노드의 자식 노드가 없다면 level 리턴
        if(root.lt == null && root.rt == null) {
            return level;
        } else {
            // 리턴된 값 중, 더 작은 값 리턴
            return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
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