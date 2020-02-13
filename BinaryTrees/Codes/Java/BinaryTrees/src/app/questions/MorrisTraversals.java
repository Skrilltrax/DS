package app.questions;

import app.Node;
import app.utils.BinaryTreeUtils;

public class MorrisTraversals {

    public static boolean flag = false;

    public static void traverseInorder(Node curr) {
        Node nextLeft = curr;
        while (curr != null) {

            if (curr.left == null || flag == true) {
                System.out.println(curr.data);
                curr = curr.right;
                flag = false;
                if (curr.right == null) {
                    break;
                }
            }

            if (curr != null && curr.left != null) {
                nextLeft = curr.left;

                while (nextLeft.right != null && nextLeft.right != curr) {
                    nextLeft = nextLeft.right;
                }

                if (nextLeft.right == curr) {
                    nextLeft.right = null;
                    flag = true;
                    continue;
                } else {
                    nextLeft.right = curr;
                }
                curr = curr.left;
            }
        }
    }

    public static void traversePreorder(Node curr) {
        Node nextLeft = curr;
        while (curr != null) {

            if (curr.left == null || flag == true) {
                if (curr.left == null) {
                    System.out.println(curr.data);
                }
                curr = curr.right;
                flag = false;
            }

            if (curr != null && curr.left != null) {
                nextLeft = curr.left;
                while (nextLeft.right != null && nextLeft.right != curr) {
                    nextLeft = nextLeft.right;
                }

                if (nextLeft.right == curr) {
                    nextLeft.right = null;
                    flag = true;
                    continue;
                } else {
                    System.out.println(curr.data);
                    nextLeft.right = curr;
                }
                curr = curr.left;
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        // int[] nodes = { 20, 10, -1, -1, 30, -1, -1};
        Node root = BinaryTreeUtils.createTree(nodes);
        // BinaryTreeUtils.printTree(root);
        traversePreorder(root);
    }
}