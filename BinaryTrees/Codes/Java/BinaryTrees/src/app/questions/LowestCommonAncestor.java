package app.questions;

import java.util.ArrayList;
import app.Node;
import app.utils.*;

/**
 * LCA [100 90 70 50 10] [ 70 50 10] ans = 70
 */

public class LowestCommonAncestor {

    public static Node lcaNode;

    public static int printLCABad(Node node, int data1, int data2) {
        ArrayList<Node> list1 = PathUtils.getPath(node, data1, 4);
        ArrayList<Node> list2 = PathUtils.getPath(node, data2, 4);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        int result = -1;
        for (; i >= 0 && j >= 0; i--, j--) {
            if (list1.get(i).data != list2.get(j).data) {
                break;
            }
            result = list1.get(i).data;
        }
        return result;
    }

    /**
     * * Statically sets lca node.
     * 
     * @param node
     * @param data1
     * @param data2
     * @return
     * 
     */

    public static boolean printLCAOkay(Node node, int data1, int data2) {
        if (node == null)
            return false;

        boolean isSelfNode = (node.data == data1) || (node.data == data2);

        boolean leftRes = printLCAOkay(node.left, data1, data2);
        if (lcaNode != null)
            return true;

        boolean rightRes = printLCAOkay(node.right, data1, data2);
        if (lcaNode != null)
            return true;

        if ((leftRes && isSelfNode) || (rightRes && isSelfNode) || (leftRes && rightRes)) {
            lcaNode = node;
            return true;
        }

        return leftRes || rightRes || isSelfNode;
    }

    /**
     * 
     * @param node
     * @param data1
     * @param data2
     * @return
     */

    public static Node printLCAGood(Node node, int data1, int data2) {
        if (node == null)
            return null;

        boolean isSelfNode = (node.data == data1) || (node.data == data2);

        Node leftRes = printLCAGood(node.left, data1, data2);
        Node rightRes = printLCAGood(node.right, data1, data2);

        if (leftRes != null && rightRes != null)
            return node;
        if (leftRes != null)
            return isSelfNode ? node : leftRes;
        if (rightRes != null)
            return isSelfNode ? node : rightRes;
        if (leftRes == null && rightRes == null && isSelfNode)
            return node;
        return null;
    }

    public static void main(String[] args) {
        int[] nodes = {10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1,
                -1, -1};

        Node root = BinaryTreeUtils.createTree(nodes);

        LowestCommonAncestor.printLCAOkay(root, 20, 30);
        System.out.println(lcaNode.data);
    }
}
