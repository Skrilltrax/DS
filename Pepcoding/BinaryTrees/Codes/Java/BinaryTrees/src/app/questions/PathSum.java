package app.questions;

import app.Node;
import java.util.ArrayList;
import java.util.HashMap;

import app.utils.BinaryTreeUtils;

public class PathSum {

    public static boolean pathSumI(Node node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && sum - node.data == 0 )
            return true;

        return pathSumI(node.left, sum - node.data) || pathSumI(node.right, sum - node.data);
    }

    public static ArrayList<ArrayList<Integer>> pathSumII(Node node, int sum) {
        if (node == null)
            return null;

        if (node.left == null && node.right == null && sum - node.data == 0) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> base = new ArrayList<Integer>();
            base.add(node.data);
            ans.add(base);
            return ans;
        }

        ArrayList<ArrayList<Integer>> left = pathSumII(node.left, sum - node.data);
        if (left != null) {
            for (ArrayList<Integer> list : left) {
                list.add(0, node.data);
            }
        }

        ArrayList<ArrayList<Integer>> right = pathSumII(node.right, sum - node.data);
        if (right != null) {
            for (ArrayList<Integer> list : right) {
                list.add(0, node.data);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.addAll(left);
        ans.addAll(right);
        return ans;
    }


    // * Always make sure map contains (o -> 1) before passing to recursion
    public static int pathSumIII(Node node, int prefixSum, int target, HashMap<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        prefixSum += node.data;

        int count = map.getOrDefault(prefixSum - target, 0);
        
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        count += pathSumIII(node.left, prefixSum, target, map);
        count += pathSumIII(node.right, prefixSum, target, map);

        if (map.get(prefixSum) == 1) {
            map.remove(prefixSum);
        } else {
            map.put(prefixSum, map.get(prefixSum) - 1);
        }

        return count;
    }

    static int maxLeafSum = Integer.MIN_VALUE;

    // * Max sum b/w 2 leaves
    public static int leafToLeafSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftNodeToLeaf = leafToLeafSum(node.left);
        int rightNodeToLeaf = leafToLeafSum(node.right);

        if (node.left != null && node.right != null) {
            maxLeafSum = Math.max(maxLeafSum, leftNodeToLeaf + rightNodeToLeaf + node.data);
            return Math.max(leftNodeToLeaf, rightNodeToLeaf) + node.data;
        }

        return ((node.left == null) ? rightNodeToLeaf : leftNodeToLeaf) + node.data;
    }

    static int maxPathSum = Integer.MIN_VALUE;

    public static int nodeToNodeSum(Node node) {
        if (node == null) {
            return 0;
        }

        int leftNodeToNode = nodeToNodeSum(node.left);
        int rightNodeToNode = nodeToNodeSum(node.right);

        int maxLeft = Math.max(leftNodeToNode, leftNodeToNode + node.data);
        int maxRight = Math.max(rightNodeToNode, rightNodeToNode + node.data);
        int maxLR = Math.max(maxLeft, maxRight);
        int max = Math.max(maxLR, leftNodeToNode + rightNodeToNode + node.data);
        maxPathSum = max;
        
        return maxLR;
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        Node root = BinaryTreeUtils.createTree(nodes);
        BinaryTreeUtils.printTree(root);
    }
}