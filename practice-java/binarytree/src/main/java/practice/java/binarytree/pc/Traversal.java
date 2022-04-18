package practice.java.binarytree.pc;

import practice.java.binarytree.Node;

import java.util.Stack;

public class Traversal {

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

    public static void preOrderTraversal(Node<Integer> node) {
        if (node == null) {
            return;
        }

        System.out.println("Node: " + node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(Node<Integer> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println("Node: " + node.data);
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node<Integer> node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println("Node: " + node.data);
    }

    public static void preOrderTraversalIterative(Node<Integer> node) {
        if (node == null) return;

        Stack<NodeState> nodeStateStack = new Stack<>();
        NodeState nodeState = new NodeState(node, State.LEFT);
        nodeStateStack.push(nodeState);

        while (!nodeStateStack.isEmpty()) {
            NodeState top = nodeStateStack.peek();

            // This means that it is the first time we are visiting this node so print the node data now for preorder
            // traversal.
            if (top.state == State.LEFT) System.out.println("Node: " + top.node.data);

            evaluateNodeState(nodeStateStack, top);
        }
    }

    public static void inOrderTraversalIterative(Node<Integer> node) {
        if (node == null) return;

        Stack<NodeState> nodeStateStack = new Stack<>();
        NodeState nodeState = new NodeState(node, State.LEFT);
        nodeStateStack.push(nodeState);

        while (!nodeStateStack.isEmpty()) {
            NodeState top = nodeStateStack.peek();

            // This means that it is the second time we are visiting this node so print the node data now for inorder
            // traversal.
            if (top.state == State.RIGHT) System.out.println("Node: " + top.node.data);

            evaluateNodeState(nodeStateStack, top);
        }
    }

    public static void postOrderTraversalIterative(Node<Integer> node) {
        if (node == null) return;

        Stack<NodeState> nodeStateStack = new Stack<>();
        NodeState nodeState = new NodeState(node, State.LEFT);
        nodeStateStack.push(nodeState);

        while (!nodeStateStack.isEmpty()) {
            NodeState top = nodeStateStack.peek();

            // This means that it is the third time we are visiting this node so print the node data now for postorder
            // traversal.
            if (top.state == State.POP) System.out.println("Node: " + top.node.data);

            evaluateNodeState(nodeStateStack, top);
        }
    }

    private static void evaluateNodeState(Stack<NodeState> nodeStateStack, NodeState top) {
        switch (top.state) {
            case LEFT -> {
                // Update the state as soon as we enter the block
                // We are not doing it after the if condition below because otherwise it will continue the loop
                // without updating state.
                top.updateState();

                if (top.node.left == null) return;

                NodeState childNodeState = new NodeState(top.node.left, State.LEFT);
                nodeStateStack.push(childNodeState);
            }
            case RIGHT -> {
                // Update the state as soon as we enter the block
                // We are not doing it after the if condition below because otherwise it will continue the loop
                // without updating state.
                top.updateState();

                if (top.node.right == null) return;

                NodeState childNodeState = new NodeState(top.node.right, State.LEFT);
                nodeStateStack.push(childNodeState);
            }
            case POP -> nodeStateStack.pop();
        }
    }
}
