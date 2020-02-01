package app;

public class AVLNode {
    public int data;
    public int height;
    public int balance;
    public AVLNode left;
    public AVLNode right;

    public AVLNode(int data, AVLNode left, AVLNode right, int height, int balance) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
        this.balance = balance;
    }
    
    public AVLNode(int data) {
        this(data, null, null, -1, 0);
    }

    public AVLNode() {
        this(Integer.MIN_VALUE, null, null, -1, 0);
    }
}