public class BinaryTreeUtils {

    static int index = 0;

    public static Node createBinaryTree(int nodes[]) {

        if (index == nodes.length || nodes[index] == -1) {
            index++;
            return null;
        }

        Node node = new Node(nodes[index++]);

        node.left = createBinaryTree(nodes);
        node.right = createTree(nodes);

        return node;
    }

    public static Node createTree(int nodes[]) {
        index = 0;
        Node root = createBinaryTree(nodes);
        return root;
    }

    public static void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " : ");
        if (node.left != null) {
            System.out.print(" L" + node.left.data);
        }
        if (node.right != null) {
            System.out.print(" R" + node.right.data);
        }
        System.out.println();
        printTree(node.left);
        printTree(node.right);
    }

    public static int getSize(Node node) {
        if (node == null)
            return 0;

        int leftSize = getSize(node.left);
        int rightSize = getSize(node.right);

        return leftSize + rightSize + 1;
    }

    public static int getHeight(Node node) {
        if (node == null)
            return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //* Always use preorder as we won't have to visit all nodes.
    public static boolean findNode(Node root, Node node) {
        if (root == null)
            return false;

        if (root.data = node.data)
            return true;

        // boolean res = false;
        // res = res || find(node.left);
        // res = res || find(node.right);
        // return res;
        
        return findNode(root.left, node) || findNode(root.right, node)
    }

    public static void main(String args[]) {
        
    }
}
