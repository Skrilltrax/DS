package app.questions.bst;

import app.AVLNode;

public class AVLUtils {

    public static AVLNode llRotation(AVLNode node) {
        AVLNode leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        updateHeightAndBalance(node);
        updateHeightAndBalance(leftNode);
        return leftNode;
    }

    public static AVLNode rrRotation(AVLNode node) {
        AVLNode rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        updateHeightAndBalance(node);
        updateHeightAndBalance(rightNode);
        return rightNode;
    }

    public static void updateHeightAndBalance(AVLNode node) {
        int leftHeight = -1;
        int rightHeight = -1;

        if (node.left != null)
            leftHeight = node.left.height;
        if (node.right != null)
            rightHeight = node.right.height;

        node.height = Math.max(leftHeight, rightHeight) + 1;
        node.balance = leftHeight - rightHeight;
    }

    public static AVLNode rotateSubTree(AVLNode node) {
        updateHeightAndBalance(node);
        // * LL or LR Rotation
        if (node.balance == 2) {
            if (node.left.balance == 1) {
                // * LL Rotation
                llRotation(node);
            } else {
                // * LR Rotation
                node.left = rrRotation(node.left);
                return llRotation(node);
            }
        } else if (node.balance == -2) {
            // * RR or RL Rotation
            if (node.balance == -1) {
                // * RR Rotation
                rrRotation(node);
            } else {
                // * RL Rotation
                node.right = llRotation(node.right);
                return rrRotation(node);
            }
        }
        return node;
    }


    public static AVLNode createFromSortedArray(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }

        int mid = (ei + si) / 2; // Divide by 2 ( / 2); si + (ei-si)/2;
        AVLNode node = new AVLNode(arr[mid]);

        node.left = createFromSortedArray(arr, si, mid - 1);
        node.right = createFromSortedArray(arr, mid + 1, ei);
        updateHeightAndBalance(node);
        return node;
    }

    public static AVLNode addNode(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        }

        if (data < node.data) {
            node.left = addNode(node.left, data);
        } else {
            node.right = addNode(node.right, data);
        }
        updateHeightAndBalance(node);
        return node;
    }

    public static int getMaxNode(AVLNode node) {
        if (node.right == null)
            return node.data;

        int ans = getMaxNode(node.right);
        return ans;
    }

    public static AVLNode removeNode(AVLNode root, int target) {
        if (root == null)
            return null;
        if (root.data == target) {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            int maxNodeLeft = getMaxNode(root.left);
            root.data = maxNodeLeft;
            root.left = removeNode(root.left, maxNodeLeft);
            updateHeightAndBalance(root);
            return root;
        }

        // if (root.data == target) {
        // if (root.left == null && root.right == null) {
        // return null;
        // } else if (root.right == null) {
        // return root.left;
        // } else if (root.left == null) {
        // return root.right;
        // } else {
        // int maxData = getMaxNode(root.left);
        // root.data = maxData;
        // root.left = removeNode(root.left, maxData);
        // return root;
        // }
        // }

        if (target < root.data) {
            root.left = removeNode(root.left, target);
        } else {
            root.right = removeNode(root.right, target);
        }
        updateHeightAndBalance(root);
        return root;
    }
}