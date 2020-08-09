import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class QueueNode implements Comparable<QueueNode> {
        public TreeNode node;
        public int level;
        public int depth;

        public QueueNode(TreeNode node, int level, int depth) {
            this.node = node;
            this.level = level;
            this.depth = depth;
        }

        @Override
        public int compareTo(QueueNode other) {
            if (this.depth == other.depth) {
                if (this.level == other.level) {
                    return this.node.val - other.node.val;
                } else {
                    return this.level - other.level;
                }
            } else {
                return this.depth - other.depth;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        PriorityQueue<QueueNode> q = new PriorityQueue<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        q.add(new QueueNode(root, 0, 0));

        int minLevel = 0;
        int maxLevel = 0;

        while (q.size() > 0) {
            QueueNode n = q.poll();

            if (!map.containsKey(n.level)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n.node.val);
                map.put(n.level, list);
            } else {
                ArrayList<Integer> list = map.get(n.level);
                list.add(n.node.val);
            }

            if (n.node.left != null) {
                q.add(new QueueNode(n.node.left, n.level - 1, n.depth + 1));
                minLevel = Math.min(minLevel, n.level - 1);
            }

            if (n.node.right != null) {
                q.add(new QueueNode(n.node.right, n.level + 1, n.depth + 1));
                maxLevel = Math.max(maxLevel, n.level + 1);
            }
        }

        ArrayList<List<Integer>> list = new ArrayList<>();

        for (int i = minLevel; i <= maxLevel; i++) {
            list.add(map.get(i));
        }

        return ((List<List<Integer>>) list);
    }
}