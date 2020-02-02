package app.questions.bst;

import app.AVLNode;
import app.Node;
import app.utils.BinaryTreeUtils;

public class BSTUtils {

    public static Node createFromSortedArray(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (ei + si) / 2; // Divide by 2 ( / 2); si + (ei-si)/2;
        Node node = new Node(arr[mid]);

        node.left = createFromSortedArray(arr, si, mid - 1);
        node.right = createFromSortedArray(arr, mid + 1, ei);

        return node;
    }

    public static Node addNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = addNode(node.left, data);
        } else {
            node.right = addNode(node.right, data);
        }
        return node;
    }

    public static int getMaxNode(Node node) {
        if (node.right == null)
            return node.data;

        int ans = getMaxNode(node.right);
        return ans;
    }

    public static Node removeNode(Node root, int target) {
        if (root == null)
            return null;
        if (root.data == target) {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            int maxNodeLeft = getMaxNode(root.left);
            root.data = maxNodeLeft;
            root.left = removeNode(root.left, maxNodeLeft);
            return root;
        }

        // if (root.data == target) {
        //     if (root.left == null && root.right == null) {
        //         return null;
        //     } else if (root.right == null) {
        //         return root.left;
        //     } else if (root.left == null) {
        //         return root.right;
        //     } else {
        //         int maxData = getMaxNode(root.left);
        //         root.data = maxData;
        //         root.left = removeNode(root.left, maxData);
        //         return root;
        //     }
        // }

        if (target < root.data) {
            root.left = removeNode(root.left, target);
        } else {
            root.right = removeNode(root.right, target);
        }
        return root;
    }

    public static void printTree(AVLNode node) {
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

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Node res = createFromSortedArray(arr, 0, arr.length - 1);
        BinaryTreeUtils.printTree(res);
        addNode(res, 100);
        BinaryTreeUtils.printTree(res);
        removeNode(res, 70);
        BinaryTreeUtils.printTree(res);
    }
}