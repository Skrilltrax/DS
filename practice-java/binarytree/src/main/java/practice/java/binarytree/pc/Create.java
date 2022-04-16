package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class Create {

    public enum State {
        LEFT,
        RIGHT,
        POP
    }

    public static class NodeState {
        Node<Integer> node;
        State state;

        public NodeState(Node<Integer> node, State state) {
            this.node = node;
            this.state = state;
        }

        public void updateState() {
            switch (state) {
                case LEFT -> state = State.RIGHT;
                case RIGHT -> state = State.POP;
                case POP -> throw new IllegalStateException("Cannot update state, it is already State.POP");
            }
        }
    }

    public static Node<Integer> createIntBinaryTreeFromPreorder(ArrayList<Integer> nodes) {
        // Create a stack
        Stack<NodeState> nodeStack = new Stack<>();
        Node<Integer> root = new Node<>(nodes.get(0));
        NodeState ns = new NodeState(root, State.LEFT);

        nodeStack.push(ns);

        int index = 0;

        while(!nodeStack.isEmpty()) {
            NodeState top = nodeStack.peek();

            if (top.state == State.LEFT) {
                // update index to get the next item
                index++;
                // Update current node's state
                top.updateState();

                Integer leftValue = nodes.get(index);
                if (leftValue == null) {
                    continue;
                }

                // Save next item in current node's left
                top.node.left = new Node<>(leftValue);
                // Push the left node to stack
                NodeState leftNodeState = new NodeState(top.node.left, State.LEFT);
                nodeStack.push(leftNodeState);
            } else if (top.state == State.RIGHT) {
                // update index to get the next item
                index++;
                // Update current node's state
                top.updateState();

                Integer rightValue = nodes.get(index);
                if (rightValue == null) {
                    continue;
                }

                // Save next item in current node's right
                top.node.right = new Node<>(rightValue);
                // Push the right node to stack
                NodeState rightNodeState = new NodeState(top.node.right, State.LEFT);
                nodeStack.push(rightNodeState);
            } else {
                nodeStack.pop();
            }
        }

        return root;
    }
}
