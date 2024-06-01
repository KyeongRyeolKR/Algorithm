import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char val = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            setNode(head, val, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }
    
    public static void preOrder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }
    
    public static void inOrder(Node n) {
        if (n == null) {
            return;
        }
        inOrder(n.left);
        System.out.print(n.val);
        inOrder(n.right);
    }
    
    public static void postOrder(Node n) {
        if (n == null) {
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.print(n.val);
    }
    
    public static void setNode(Node par, char root, char left, char right) {
        if (par.val == root) {
            par.left = left == '.' ? null : new Node(left, null, null);
            par.right = right == '.' ? null : new Node(right, null, null);
        } else {
            if (par.left != null)
                setNode(par.left, root, left, right);
            if (par.right != null)
                setNode(par.right, root, left, right);
        }
    }
}

class Node {
    char val;
    Node left, right;
    Node (char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}