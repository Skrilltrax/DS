package app.utils;

import app.Node;

public class BinaryTreeUtils {

    private static int index = 0;
    
    private static Node createNode(int[] nodes) {
        if (nodes[index] == -1) {
            index++;
            return null;
        }
        Node node = new Node(nodes[index++]);
        node.left = createNode(nodes);
        node.right = createNode(nodes);
        return node;
    }

    public static Node createTree(int[] nodes) {
        index = 0;
        return createNode(nodes);
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

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static int getSize(Node node) {
        if (node == null) {
            return 0;
        }
        return getSize(node.left) + getSize(node.right) + 1;
    }

    //* Always use preorder as we won't have to visit all nodes.
    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        // boolean res = false;
        // res = res || find(node.left);
        // res = res || find(node.right);
        // return res;
        return find(node.left, data) || find(node.right, data);
    }

}