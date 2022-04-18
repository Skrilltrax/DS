package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrderTraversal(Node<Integer> node) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while (queue.size() > 1) {
            Node<Integer> childNode = queue.remove();

            if (childNode == null) {
                System.out.println();
                System.out.println("============");

                // Add null to the end of the list if we encounter a null at the front
                queue.add(null);
                continue;
            }

            // Print the current node if it is not null
            System.out.print(childNode.data + " ");

            if (childNode.left != null) queue.add(childNode.left);
            if (childNode.right != null) queue.add(childNode.right);
        }
    }
}