package app;

import app.questions.*;
import app.utils.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] nodes = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        // int[] nodes = { 20, 10, -1, -1, 30, -1, -1};
        Node root = BinaryTreeUtils.createTree(nodes);
        // BinaryTreeUtils.printTree(root);
        // System.out.println(BinaryTreeUtils.getHeight(root));
        // System.out.println(BinaryTreeUtils.getSize(root));
        // System.out.println(BinaryTreeUtils.find(root, 101));
        // ArrayList<Node> path = PathUtils.getPath(root, 100, 4);
        // for (Node node : path) {
        // System.out.println(node.data);
        // }
        // System.out.println(LowestCommonAncestor.printLCA(root, 100, 20));
        // KFar.findBest(root, 60, 1);
        // Solutions sol = new Solutions();
        // AllSolutions.solve(root, 0, 60, sol);
        // System.out.println(sol.successor.data);
        // BSTPair res = CountBST.getPair(root);
        // System.out.println(res.count + " " + res.lsize);
    }
}
