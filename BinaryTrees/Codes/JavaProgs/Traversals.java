public class Traversals {

    public static void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println("Preorder : " + node.data);
    
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        System.out.println("Inorder : " + node.data);

        inorderTraversal(node.right);
    }

    public static void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        
        System.out.println("Postorder : " + node.data);
    
    }

    public static void main(String args[]) {

    }
}
