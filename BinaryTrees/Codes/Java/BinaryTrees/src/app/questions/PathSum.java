package app.questions;

import app.Node;
import java.util.ArrayList;

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

    public static void main(String[] args) {

    }
}