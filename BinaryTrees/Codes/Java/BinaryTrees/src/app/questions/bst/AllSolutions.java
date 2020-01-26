package app.questions.bst;

import app.Node;

public class AllSolutions {

    public static class Solutions {
        boolean find = false;
        
        public int height = 0;
        public int size = 0;
        public int ciel = Integer.MAX_VALUE; // (int) 1e8
        public int floor = Integer.MIN_VALUE; // (int) -1e8
        
        public Node previous = null;
        public Node predecessor = null;
        public Node successor = null;
    }

    public static void solve(Node node, int level, int data, Solutions sol) {
        if (node == null) {
            return;
        }
        sol.size++;
        sol.height = Math.max(sol.height, level);
        sol.find = sol.find || (node.data == data);

        if (node.data > data && node.data < sol.ciel) {
            sol.ciel = node.data;
        }

        if (node.data < data && node.data > sol.floor) {
            sol.floor = node.data;
        }

        if (sol.previous != null && node.data == data) {
            sol.predecessor = sol.previous;
        }

        if (sol.previous != null && sol.previous.data == data) {
            sol.successor = node;
        }

        sol.previous = node;
        solve(node.left, level + 1, data, sol);
        solve(node.right, level + 1, data, sol);
    }
}
