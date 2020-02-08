import java.util.ArrayList;

public class Node {
    public int data;
    public ArrayList<Node> children;

    Node() {
        this(0);
    }

    Node(int data) {
        this.data = data;
        children = null;
    }
}