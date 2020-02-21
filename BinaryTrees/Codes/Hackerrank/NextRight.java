//package interview.binaryTree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class NextRight {
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

		int data = scn.nextInt();
//		display(root);

        solve(root, data);
        scn.close();
	}

	private static void solve(Node root, int data){
        
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.add(root);
        queue.add(null);
        
        while(queue.size() > 1)
        {
            Node p = queue.remove();
            if (p == null) {
                queue.add(null);
                continue;
            }
            
            if (p.data == data) {
                Node r = queue.peek(); 
                if (r == null) {
                    System.out.println("Not Found");
                    break;
                } else {
                    System.out.println(r.data);
                    break;
                }
            }
            
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }
	}

}