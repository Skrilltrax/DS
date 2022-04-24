package practice.java.binarytree.lc;

import practice.java.binarytree.Node;

// LC: 98
// https://leetcode.com/problems/validate-binary-search-tree
// https://www.youtube.com/watch?v=s6ATEkipzow
public class IsValidBST {
    public Integer prev = null;

    public static boolean isValidBST(Node<Integer> root) {
        // null means infinity here. More specifically, null as a left boundary means -inf  and null as right boundary means +inf
        return checkSubtreeRange(root, null, null);
    }

    private static boolean checkSubtreeRange(Node<Integer> node, Integer leftBoundary, Integer rightBoundary) {
        // If node is null, subtree is valid
        if (node == null) return true;

        // If left boundary is not null (-inf), then check if node's value is more than leftBoundary
        if (leftBoundary != null) {
            if (node.data <= leftBoundary) return false;
        }

        // If right boundary is not null (+inf), then check if node's value is less than rightBoundary
        if (rightBoundary != null) {
            if (node.data >= rightBoundary) return false;
        }

        // Reaching here means that our node's value is greater than leftBoundary and less than rightBoundary
        boolean left = checkSubtreeRange(node.left, leftBoundary, node.data);
        boolean right = checkSubtreeRange(node.right, node.data, rightBoundary);

        return left && right;
    }

    // Here we traverse the tree in an inorder fashion. In a BST, the inorder traversal will always be sorted.
    // So we check the previous value to see if that is smaller than the current value. If that is the case throughout
    // the whole tree, we say that this BST is valid.
    public boolean checkSubtreeInorder(Node<Integer> node) {
        if (node == null) return true;

        boolean leftResult = checkSubtreeInorder(node.left);

        if (prev != null && node.data <= prev) {
            return false;
        }
        prev = node.data;

        boolean rightResult = checkSubtreeInorder(node.right);

        return leftResult && rightResult;
    }


}
