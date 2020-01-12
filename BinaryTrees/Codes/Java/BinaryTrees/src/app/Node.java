package app;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node() {
        data = Integer.MIN_VALUE;
        left = null;
        right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = Integer.MIN_VALUE;
        this.left = null;
        this.right = null;
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}