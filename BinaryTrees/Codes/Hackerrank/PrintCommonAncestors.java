//package interview.binaryTree;
// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-10binarytrees-334printcommonancestors

import java.util.Scanner;

public class PrintCommonAncestors {
	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " <= " + node.data + " => ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		// creation using the level order, seeing it like a heap
		// -1 says there is no node
		Node[] nodes = new Node[arr.length];
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}
		Node root = nodes[0];
		int d1 = scn.nextInt();
		int d2 = scn.nextInt();
		// display(root);

		lca(root, d1, d2, 0);
	}

	static Node lca;

	private static boolean lca(Node node, int d1, int d2, int level) {
        if (node == null)
            return false;
        
        boolean selfDone = node.data == d1 || node.data == d2;
        
        boolean leftAns = lca(node.left, d1, d2, level + 1);
        if (lca != null) {
            System.out.print(node.data + " ");
            return true;
        }
        boolean rightAns = lca(node.right, d1, d2, level + 1);
        if (lca != null) {
            System.out.print(node.data + " ");
            return true;
        }
        
        if ((leftAns && rightAns) || (leftAns && selfDone) || (rightAns && selfDone)) {
            lca = node;
            System.out.print(node.data + " ");
            return true;
        }
        
        return leftAns || rightAns || selfDone;
        
	}
 
}