package app.questions;

import app.Node;
import app.utils.*;

public class Diameter {

    /**
     ** To get diameter we need to get diameter of left vs diameter of right vs the total distance
     ** of left subtree + right subtree +1 (for current node).
     **/

    private static int diameter = 0;

    // ! Takes O(n^2) time because for each node height is being calculated
    private static int getDiameterBad(Node node) {
        if (node == null) {
            return 0;
        }

        int diameterLeft = getDiameterBad(node.left);
        int diameterRight = getDiameterBad(node.right);

        int heightLeft = BinaryTreeUtils.getHeight(node.left);
        int heightRight = BinaryTreeUtils.getHeight(node.right);

        return Math.max(Math.max(diameterLeft, diameterRight), heightLeft + heightRight + 1);
    }

    // ? Takes O(n) time but more space
    private static int[] getDiameterOkay(Node node) {
        if (node == null) {
            return new int[2];
        }

        int[] left = getDiameterOkay(node.left);
        int[] right = getDiameterOkay(node.right);

        int[] result = new int[2];

        // * Don't calculate height from scratch, height of each tree = 1 + height of subtree

        result[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        result[1] = Math.max(left[1], right[1]) + 1;
        return result;
    }

    // ? Takes O(n) time and O(1) space
    private static int getDiameterBest(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getDiameterBest(node.left);
        int right = getDiameterBest(node.right);

        diameter = Math.max(diameter, left + right + 1);

        return Math.max(left, right) + 1;
    }

    public static int getDiameter(Node node, int method) {
        diameter = 0;
        int result = -1;
        int[] resultArr = new int[2];
        switch (method) {
            case 1:
                result = getDiameterBad(node);
                break;
            case 2:
                resultArr = getDiameterOkay(node);
                result = resultArr[0];
                break;
            case 3:
                result = getDiameterBest(node);
                break;
            default:
                System.out.println("There are only 3 choices");
        }
        return result;
    }
}
