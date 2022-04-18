package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    public static boolean rootToLeafPath(Node<Integer> node, int targetSum) {
        return rootToLeafPathRecursive(node, targetSum, 0);
    }

    public static ArrayList<List<Integer>> rootToLeafPathArrayList(Node<Integer> node, int targetSum) {
        return rootToLeafPathRecursiveArrayList(node, targetSum);
    }

    private static boolean rootToLeafPathRecursive(Node<Integer> node, int targetSum, int currentSum) {
        // If we go below a leaf node, return false from there
        if (node == null) return false;

        // If it is leaf node, and we have the required sum
        if (node.left == null && node.right == null && node.data + currentSum == targetSum) return true;

        boolean leftResult = rootToLeafPathRecursive(node.left, targetSum, currentSum + node.data);
        boolean rightResult = rootToLeafPathRecursive(node.right, targetSum, currentSum + node.data);

        return leftResult || rightResult;
    }

    private static boolean rootToLeafPathRecursive(Node<Integer> node, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null && targetSum - node.data == 0) return true;

        return rootToLeafPathRecursive(node.left, targetSum - node.data) || rootToLeafPathRecursive(node.right, targetSum - node.data);
    }

    private static ArrayList<List<Integer>> rootToLeafPathRecursiveArrayList(Node<Integer> node, int targetSum) {
        if (node == null) return null;
        if (node.left == null && node.right == null && targetSum - node.data == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<List<Integer>> combinedList = new ArrayList<>();
            list.add(node.data);
            combinedList.add(list);

            return combinedList;
        }

        ArrayList<List<Integer>> leftList = rootToLeafPathRecursiveArrayList(node.left, targetSum - node.data);
        ArrayList<List<Integer>> rightList = rootToLeafPathRecursiveArrayList(node.right, targetSum - node.data);

        ArrayList<List<Integer>> combinedList = new ArrayList<>();

        if (leftList != null) {
            leftList.forEach(list -> list.add(node.data));
            combinedList.addAll(leftList);
        }

        if (rightList != null) {
            rightList.forEach(list -> list.add(node.data));
            combinedList.addAll(rightList);
        }

        return combinedList;
    }
}
