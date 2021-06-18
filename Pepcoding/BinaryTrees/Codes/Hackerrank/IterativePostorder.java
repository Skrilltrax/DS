//package interview.binaryTree;
// https://www.hackerrank.com/contests/pep-levelup-jan2020/challenges/pep-javaip-10binarytrees-317iterativepostorder/

import java.util.LinkedList;
import java.util.Scanner;

public class IterativePostorder {
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
		str += " => " + node.data + " <= ";
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

		solve(nodes[0]);
        scn.close();
	}

    public static class NodeData {
        Node node;
        boolean left;
        boolean self;
        boolean right;
        
        public NodeData(Node node) {
            this(node,false,false,false);
        }
        
        public NodeData(Node node, boolean left, boolean self, boolean right) {
            this.node = node;
            this.left = left;
            this.self = self;
            this.right = right;
        }
    }
    
	private static void solve(Node root){
		// LinkedList<Node> processStack = new LinkedList<>();
		LinkedList<NodeData> stack = new LinkedList<>();
		
      	// code this here

        NodeData node = new NodeData(root);
        stack.push(node);
        
        while(stack.size() > 0) {
            
            NodeData p = stack.peekLast();
            if (!p.left) {
                if (p.node.left != null)
                    stack.addLast(new NodeData(p.node.left));
                p.left = true;
            } else if (!p.right) {
                if (p.node.right != null)
                    stack.addLast(new NodeData(p.node.right));
                p.right = true;
            } else if (!p.self) {
                System.out.print(p.node.data + " ");
                p.self = true;
            } else {
                stack.removeLast();
            }
        }
        
	}

}