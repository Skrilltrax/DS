package app.questions.bst;

import java.util.Random;

import app.AVLNode;
import app.utils.BinaryTreeUtils;

public class BSTLCA {

    public static AVLNode lca(AVLNode node, AVLNode node1, AVLNode node2) {
        if (node == null) {
            return null;
        }

        if (node.data < node1.data) {
            return lca(node.right, node1, node2);
        }
        if (node.data > node2.data) {
            return lca(node.left, node1, node2);
        }
        return node;
    }

    public static void printRange(AVLNode node, int range1, int range2) {
        if (node == null) {
            return;
        }
        
        if (node.data < range1) {
            printRange(node.right, range1, range2);
        } else if (node.data > range2) {
            printRange(node.left, range1, range2);
        } else {
            System.out.println(node.data + " ");
            printRange(node.left, range1, range2);
            printRange(node.right, range1, range2);
        }
    }

    public static AVLNode findLCA(AVLNode node, AVLNode node1, AVLNode node2) {
        
        // TODO: Write find fuction for BST to check if nodes exist
        
        // * if (find (node, node1.data) && find(node.node2.data) && node1.data < node2.data)) {
        // *    lca(node, node1, node2);   
        // * }

        AVLNode ans = lca(node, node1, node2);
        System.out.println(ans.data);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        AVLNode res = AVLUtils.createFromSortedArray(arr, 0, arr.length - 1);
        printRange(res, 20, 70);
    }
}