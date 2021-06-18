// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-10binarytrees-340maxwidth/
//package interview.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class MaxWidth {
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
//		display(root);

		int width1 = solveLevelWay(root);
		solvePreorderWay(root, 0, new HashMap<>());
		System.out.println(width1 + " " + width);
		scn.close();
	}

	private static int solveLevelWay(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        
        int level = 0;
        int max = Integer.MIN_VALUE;
        while(queue.size() > 1)
        {
            Node p = queue.remove();
            if (p == null) {
                level++;
                if (queue.size() > max) {
                    max = queue.size();
                }
                queue.add(null);
                continue;
            }
            
            if (p.left != null)
                queue.add(p.left);
            if (p.right != null)
                queue.add(p.right);
        }
        
        return max;
	}

	static int width = Integer.MIN_VALUE;
	private static void solvePreorderWay(Node node, int level, HashMap<Integer, Integer> lwmap){
        if (node == null) {
            return;
        }
        
        solvePreorderWay(node.left, level + 1, lwmap);
        solvePreorderWay(node.right, level + 1, lwmap);

        int pr = lwmap.getOrDefault(level, 0);
        lwmap.put(level, pr + 1);
        if (pr + 1 > width)
            width = pr + 1;
	}

}