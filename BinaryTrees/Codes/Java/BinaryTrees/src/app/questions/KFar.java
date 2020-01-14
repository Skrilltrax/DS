package app.questions;

import app.Node;
import app.utils.PathUtils;
import java.util.ArrayList;

public class KFar {

    public static int findBest(Node node, int data, int distance) {
        if (node == null) {
            return -1;
        }
        if (node.data == data) {
            KAway.find(node, distance, null);
            return distance - 1;
        }
        int depthLeft = findBest(node.left, data, distance);
        if (depthLeft != -1) {
            if (depthLeft == 0) {
                System.out.println(node.data + "");
                return -1;
            } else {
                KAway.find(node, depthLeft, node.left);
            }
            return depthLeft - 1;
        }
        int depthRight = findBest(node.right, data, distance);
        if (depthRight != -1) {
            if (depthRight == 0) {
                System.out.println(node.data + "");
                return -1;
            } else {
                KAway.find(node, depthRight, node.right);
            }
            return depthLeft - 1;
        }
        return -1;
    }

    /**
     * @param node     the root node of tree
     * @param data     the node from which K far nodes are to be found
     * @param distance the distance at which K nodes are * Uses O(n) time and O(1)
     *                 space
     */

    public static int findGood(Node node, int data, int distance) {
        if (node == null) {
            return -1;
        }
        if (node.data == data) {
            return 1;
        }
        int depthLeft = findGood(node.left, data, distance);
        if (depthLeft != -1) {
            if (depthLeft == distance) {
                System.out.println(node.data + "");
            } else {
                KAway.find(node, distance - depthLeft, node.left);
            }
            return depthLeft + 1;
        }
        int depthRight = findGood(node.right, data, distance);
        if (depthRight != -1) {
            if (depthRight == distance) {
                System.out.println(node.data + "");
            } else {
                KAway.find(node, distance - depthRight, node.right);
            }
            return depthLeft + 1;
        }
        return -1;
    }

    /**
     * @param node     the root node of tree
     * @param data     the node from which K far nodes are to be found
     * @param distance the distance at which K nodes are away ! Uses O(n) time and
     *                 space
     */

    public static void findBad(Node node, int data, int distance) {
        ArrayList<Node> path = PathUtils.getPath(node, data, 4);
        Node rnode = null;
        for (int i = 0; i < path.size(); i++) {
            KAway.find(path.get(i), distance - i, rnode);
            rnode = path.get(i);
        }
    }
}
