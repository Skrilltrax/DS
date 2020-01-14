package app.questions;

import app.Node;

/**
 * * Print all elements K distance below the given node.
 * @param node acts as root node to find all nodes below it.
 * @param distance the distance at which nodes are to be found.
 * @param rnode Returning node to be used in KFar.java to prevent iterating tree node again.  
 */

public class KAway {

    public static void find(Node node, int distance, Node rnode) {
        if (distance < 0) {
            return;
        }
        if (node == null) {
            return;
        }
        if (node == rnode) {
            return;
        }
        if (distance == 0) {
            System.out.println(node.data);
            return;
        }

        find(node.left, distance - 1, rnode);
        find(node.right, distance - 1, rnode);
    }
    
}