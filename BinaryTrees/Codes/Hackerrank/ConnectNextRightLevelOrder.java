//package interview.binaryTree;
// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-10binarytrees-338connectnextrightlevelorder/

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class ConnectNextRightLevelOrder {
	private static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

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
		str += "[" + (node.nextRight != null ? node.nextRight.data : "null") + "]";

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
		// display(root);

		setNextRight(root);
        display(root);
        scn.close();
	}

	static Node prev;
	private static void setNextRight(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
        
        queue.add(node);
        queue.add(null);
        while(queue.size() > 1) {
            if (queue.peek() == null) {
                queue.remove();
                queue.add(null);
            }
            prev = queue.remove();
            
            if (prev.left != null)
                queue.add(prev.left);
            if (prev.right != null)
                queue.add(prev.right);
            
            prev.nextRight = queue.peek();
        }
	}
}