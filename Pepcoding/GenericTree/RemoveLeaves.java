public class RemoveLeaves {

    public static Node remove(Node node) {

        for (int i = node.children.size() - 1; i>= 0; i--) {
            Node n = node.children.get(i);
            if (n.children.size() == 0) {
                node.children.remove(i);
                continue;
            } 
            remove(n);
        }
        return node;
    }

    // public static void main(String[] args) {
    //     remove(node)
    // }
}