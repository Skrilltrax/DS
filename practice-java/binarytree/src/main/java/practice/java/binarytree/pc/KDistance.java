package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.ArrayList;
import java.util.List;

public class KDistance {

    public List<Integer> kLevelsDown(Node<Integer> node, int k) {
        return kLevelsDownRecursive(node, k);
    }

    private List<Integer> kLevelsDownRecursive(Node<Integer> node, int k) {
        if (node == null) return new ArrayList<>();

        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        List<Integer> left = kLevelsDownRecursive(node.left, k - 1);
        List<Integer> right = kLevelsDownRecursive(node.right, k - 1);
        ArrayList<Integer> list = new ArrayList<>();

        if (left.size() != 0) {
            list.addAll(left);
        }

        if (right.size() != 0) {
            list.addAll(right);
        }

        return list;
    }

    private void kLevelsDownRecursive(Node<Integer> node, int k, ArrayList<Integer> list) {
        if (node == null) return;

        if (k == 0) {
            list.add(node.data);
            return;
        }

        kLevelsDownRecursive(node.left, k - 1, list);
        kLevelsDownRecursive(node.right, k - 1, list);
    }
}
