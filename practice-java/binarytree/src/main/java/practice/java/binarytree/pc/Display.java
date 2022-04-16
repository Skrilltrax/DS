package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

public class Display {

    public static void display(Node<Integer> node) {
        if (node == null) return; // base case

        StringBuilder sb = new StringBuilder();

        if (node.left != null) {
            sb.append(node.left.data);
        } else {
            sb.append(".");
        }

        sb.append(" <- ");
        sb.append(node.data);
        sb.append(" -> ");

        if (node.right != null) {
            sb.append(node.right.data);
        } else {
            sb.append(".");
        }

        System.out.println(sb);

        display(node.left);
        display(node.right);
    }
}
