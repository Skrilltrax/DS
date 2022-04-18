/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package practice.java.binarytree;

import practice.java.binarytree.pc.Create;
import practice.java.binarytree.pc.Traversal;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {


    /*
     *                                    ┌────────┐
     *                                    │   50   │
     *                                    └────────┘
     *
     *                 ┌────────┐                            ┌────────┐
     *                 │   25   │                            │   75   │
     *                 └────────┘                            └────────┘
     *
     *     ┌────────┐              ┌────────┐    ┌────────┐              ┌────────┐
     *     │   12   │              │   37   │    │   62   │              │   87   │
     *     └────────┘              └────────┘    └────────┘              └────────┘
     *
     *                         ┌────────┐              ┌────────┐
     *                         │   30   │              │   70   │
     *                         └────────┘              └────────┘
     */
    private static ArrayList<Integer> intNodesList() {
        Integer[] nodesArr = new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        return new ArrayList<>(Arrays.asList(nodesArr));
    }

    private static Node<Integer> createIntBinaryTree() {
        ArrayList<Integer> nodes = intNodesList();
        return Create.createIntBinaryTreeFromPreorder(nodes);
    }

    public static void run() {
        Node<Integer> root = createIntBinaryTree();
        Traversal.postOrderTraversalIterative(root);
    }
}
