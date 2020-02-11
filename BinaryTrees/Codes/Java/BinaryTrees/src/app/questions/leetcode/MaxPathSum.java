package app.questions.leetcode;

import app.Node;

/**
 * * Genius solution by leetcode, just don't count -ve values
 * * if overall sum is -ve count as 0
 */

public class MaxPathSum {

    public static int max = Integer.MIN_VALUE;

    public static int maxSum(Node node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));
        max = Math.max(max, left + right + node.data);
        return Math.max(left, right) + node.data;
    }

    public static int maxPathSum(Node root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return max;
    }

    public static void main(String[] args) {

    }
}