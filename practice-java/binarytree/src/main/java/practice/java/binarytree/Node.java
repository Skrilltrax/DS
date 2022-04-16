package practice.java.binarytree;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
