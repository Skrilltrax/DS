package app;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public Node(int data) {
        this(data, null, null);
    }

    public Node() {
        this(Integer.MIN_VALUE, null, null);
    }
}