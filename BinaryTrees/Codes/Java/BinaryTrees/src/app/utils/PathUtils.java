package app.utils;

import java.util.ArrayList;
import app.Node;

public class PathUtils {
    // ! Very Bad method creates Array List on each call
    private static ArrayList<Node> getPathVeryBad(Node node, int data) {
        ArrayList<Node> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }
        if (node.data == data) {
            ans.add(node);
            return ans;
        }
        ArrayList<Node> left = getPathVeryBad(node.left, data);
        if (left.size() != 0) {
            left.add(node);
            return left;
        }
        ArrayList<Node> right = getPathVeryBad(node.right, data);
        if (right.size() != 0) {
            right.add(node);
            return right;
        }
        return ans;
    }

    // ! Bad method creates Array List when execution reaches the end or data is found
    private static ArrayList<Node> getPathBad(Node node, int data) {
        if (node == null) {
            return new ArrayList<Node>();
        }
        if (node.data == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }
        ArrayList<Node> left = getPathBad(node.left, data);
        if (left.size() != 0) {
            left.add(node);
            return left;
        }
        ArrayList<Node> right = getPathBad(node.right, data);
        if (right.size() != 0) {
            right.add(node);
            return right;
        }
        return left; // ? Both left and right are empty so it should be fine to return any one
    }

    // ? Okayish method create array list only when data is found
    private static ArrayList<Node> getPathOkay(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }
        ArrayList<Node> left = getPathOkay(node.left, data);
        if (left != null) {
            left.add(node);
            return left;
        }
        ArrayList<Node> right = getPathOkay(node.right, data);
        if (right != null) {
            right.add(node);
            return right;
        }
        return null;
    }

    // * Best method does not create any array list on its own
    private static boolean getPathGood(Node node, int data, ArrayList<Node> list) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            list.add(node);
            return true;
        }
        boolean res = false;
        res = getPathGood(node.left, data, list);
        if (res) {
            list.add(node);
            return true;
        }
        res = getPathGood(node.right, data, list);
        if (res) {
            list.add(node);
            return true;
        }
        return false;
    }

    public static ArrayList<Node> getPath(Node node, int data, int method) {
        ArrayList<Node> result = new ArrayList<Node>();
        switch(method) {
            case 1: result = getPathVeryBad(node, data);
                break;
            case 2: result = getPathBad(node, data);
                break;
            case 3: result = getPathOkay(node, data);
                break;
            case 4: getPathGood(node, data, result);
                break;
            default: System.out.println("There are only 4 choices");    
        }
        return result;
    }
} 