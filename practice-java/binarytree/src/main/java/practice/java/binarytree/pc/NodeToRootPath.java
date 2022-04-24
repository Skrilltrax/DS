package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.ArrayList;

public class NodeToRootPath {

    public static ArrayList<Integer> findNodeToRootPath(Node<Integer> node, int number) {
        ArrayList<Integer> list = new ArrayList<>();
        findNodeToRootPathRecursive(node, number, list);

        return list;
    }

    // We here assume that there would be no more than one node whose value is $number
    private static boolean findNodeToRootPathRecursive(Node<Integer> node, int number, ArrayList<Integer> list) {
        if (node == null) return false;

        if (node.data == number) {
            list.add(number);
            return true;
        }

        boolean left = findNodeToRootPathRecursive(node.left, number, list);
        boolean right = findNodeToRootPathRecursive(node.right, number, list);

        // If either left or the right subtree mentions that the number is found, add the current node to list
        if (left || right) list.add(node.data);

        return left || right;
    }

    // We here assume that there would be no more than one node whose value is $number
    private static ArrayList<Integer> findNodeToRootPathRecursive(Node<Integer> node, int number) {
        if (node == null) return new ArrayList<>();

        if (node.data == number) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            return list;
        }

        ArrayList<Integer> left = findNodeToRootPathRecursive(node.left, number);
        ArrayList<Integer> right = findNodeToRootPathRecursive(node.right, number);

        // If either left or the right subtree returns a non-empty list
        if (left.size() != 0) {
            left.add(node.data);
            return left;
        }

        if (right.size() != 0) {
            right.add(node.data);
            return right;
        }

        return new ArrayList<>();
    }
}
