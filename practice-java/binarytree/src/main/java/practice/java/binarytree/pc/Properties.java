package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

public class Properties {

    public static int size(Node<Integer> node) {
        if (node == null) return 0;

        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node<Integer> node) {
        if (node == null) return 0;

        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int max(Node<Integer> node) {
        if (node == null) return Integer.MIN_VALUE;

        int childMax = Math.max(max(node.left), max(node.right));

        return Math.max(childMax, node.data);
    }

    public static int height(Node<Integer> node) {
        // For edge height, return -1
        // For node height, return 0
        if (node == null) return -1;

        int childMax = Math.max(height(node.left), height(node.right));
        return childMax + 1;
    }
}
