import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            createNode(parentValue, leftValue, rightValue);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    static void createNode(char parent, char left, char right) {
        if (root == null) {
            root = new Node(parent);
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        } else {
            searchNode(root, parent, left, right);
        }
    }

    static void searchNode(Node node, char parent, char left, char right) {
        if (node == null) return;

        if (node.data == parent) {
            if (left != '.') node.left = new Node(left);
            if (right != '.') node.right = new Node(right);
        } else {
            searchNode(node.left, parent, left, right);
            searchNode(node.right, parent, left, right);
        }
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}