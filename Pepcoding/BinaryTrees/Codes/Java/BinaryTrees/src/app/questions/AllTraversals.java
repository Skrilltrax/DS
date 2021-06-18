package app.questions;

import java.util.Stack;

import app.Node;
import app.utils.BinaryTreeUtils;

public class AllTraversals {

    public static class TraversalNode {
        public Node node = null;
        public boolean selfDone = false;
        public boolean leftDone = false;
        public boolean rightDone = false;

        public TraversalNode() {

        }

        public TraversalNode(Node node) {
            this.node = node;
        }
    }

    public static void traversePreorder(Node node) {
        Stack<TraversalNode> stack = new Stack<>();
        stack.add(new TraversalNode(node));
        while (stack.size() >= 1) {
            TraversalNode tvNode = stack.peek();
            if (tvNode.selfDone == false) {
                System.out.println(tvNode.node.data);
                tvNode.selfDone = true;
            } else if (tvNode.leftDone == false) {
                tvNode.leftDone = true;
                if (tvNode.node.left != null)
                    stack.push(new TraversalNode(tvNode.node.left));
            } else if (tvNode.rightDone == false) {
                tvNode.rightDone = true;
                if (tvNode.node.right != null)
                    stack.push(new TraversalNode(tvNode.node.right));
            } else {
                stack.pop();
            }
        }
    }

    public static void traverseInorder(Node node) {
        Stack<TraversalNode> stack = new Stack<>();
        stack.add(new TraversalNode(node));
        while (stack.size() >= 1) {
            TraversalNode tvNode = stack.peek();
            if (tvNode.leftDone == false) {
                tvNode.leftDone = true;
                if (tvNode.node.left != null)
                    stack.push(new TraversalNode(tvNode.node.left));
            } else if (tvNode.selfDone == false) {
                System.out.println(tvNode.node.data);
                tvNode.selfDone = true;
            } else if (tvNode.rightDone == false) {
                tvNode.rightDone = true;
                if (tvNode.node.right != null)
                    stack.push(new TraversalNode(tvNode.node.right));
            } else {
                stack.pop();
            }
        }
    }

    public static void traversePostorder(Node node) {
        Stack<TraversalNode> stack = new Stack<>();
        stack.add(new TraversalNode(node));
        while (stack.size() >= 1) {
            TraversalNode tvNode = stack.peek();
            if (tvNode.leftDone == false) {
                tvNode.leftDone = true;
                if (tvNode.node.left != null)
                    stack.push(new TraversalNode(tvNode.node.left));
            } else if (tvNode.rightDone == false) {
                tvNode.rightDone = true;
                if (tvNode.node.right != null)
                    stack.push(new TraversalNode(tvNode.node.right));
            } else if (tvNode.selfDone == false) {
                System.out.println(tvNode.node.data);
                tvNode.selfDone = true;
            } else {
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        // int[] nodes = { 20, 10, -1, -1, 30, -1, -1};
        Node root = BinaryTreeUtils.createTree(nodes);
        // BinaryTreeUtils.printTree(root);
        // traversePreorder(root);
        traverseInorder(root);
    }

}